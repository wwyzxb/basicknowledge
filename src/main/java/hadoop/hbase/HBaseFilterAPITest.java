package hadoop.hbase;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: wuxiaobing
 * @Date 2018/2/2
 **/
public class HBaseFilterAPITest {
    private static final String TABLE_NAME = "studentinfo";

    private static final Table TABLE = HBaseUtils.getInstance().getTable(TABLE_NAME);

    /**
     * 测试行键过滤器，只刷选满足条件的rowKey值
     *
     * @throws IOException
     */
    @Test
    public void testRowFilter() throws IOException {
        Scan scan = new Scan();
        scan.addColumn(Bytes.toBytes("course"), Bytes.toBytes("math"));

        /**筛选值大于或等于“No.001”的rowKey的course:math的值*/
//        Filter filter = new RowFilter(CompareFilter.CompareOp.GREATER_OR_EQUAL, new BinaryComparator(Bytes.toBytes("No.001")));
//        scan.setFilter(filter);
//        ResultScanner scanner = TABLE.getScanner(scan);
//        List<Map<String, String>> resultList = new ArrayList<>();
//        for (Result result : scanner) {
//            HBaseUtils.getInstance().parseResult(result, resultList);
//        }
//        System.out.println(resultList);

        /**筛选值能匹配正则“No.*5”的rowKey的course:math的值*/
//        Filter filter1 = new RowFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator("No.*5"));
//        scan.setFilter(filter1);
//        ResultScanner scanner1 = TABLE.getScanner(scan);
//        List<Map<String, String>> resultList1 = new ArrayList<>();
//        for (Result result : scanner1) {
//            HBaseUtils.getInstance().parseResult(result, resultList1);
//        }
//        System.out.println(resultList1);

        /**筛选值包含“1”的rowKey的course:math的值*/
        Filter filter2 = new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator("1"));
        scan.setFilter(filter2);
        ResultScanner scanner2 = TABLE.getScanner(scan);
        List<Map<String, String>> resultList2 = new ArrayList<>();
        for (Result result : scanner2) {
            HBaseUtils.getInstance().parseResult(result, resultList2);
        }
        System.out.println(resultList2);
    }

    @Test
    public void testFamilyFilter() throws IOException {
        Scan scan = new Scan();
        /**这样就只会扫描info:name的值*/
        scan.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));
        /**对列族的值进行筛选*/
        Filter filter = new FamilyFilter(CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("info")));
        scan.setFilter(filter);
        ResultScanner resultScanner = TABLE.getScanner(scan);
        List<Map<String, String>> resultList = new ArrayList<>();
        for (Result result : resultScanner) {
            HBaseUtils.getInstance().parseResult(result, resultList);
        }
        System.out.println(resultList);
    }

    @Test
    public void testQualifierFilter() throws IOException {
        Scan scan = new Scan();
        scan.addFamily(Bytes.toBytes("info"));
        /**筛选列值为“math”的值，如果没有上面那样指定具体的列族，会跨列族扫描*/
        Filter filter = new QualifierFilter(CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("math")));
        scan.setFilter(filter);
        ResultScanner resultScanner = TABLE.getScanner(scan);
        List<Map<String, String>> resultList = new ArrayList<>();
        for (Result result : resultScanner) {
            HBaseUtils.getInstance().parseResult(result, resultList);
        }
        System.out.println(resultList);
    }

    @Test
    public void testValueFilter() throws IOException {
        Scan scan = new Scan();
        /**对cell中的值进行匹配*/
        Filter filter = new ValueFilter(CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("90")));
        scan.setFilter(filter);
        ResultScanner resultScanner = TABLE.getScanner(scan);
        List<Map<String, String>> resultList = new ArrayList<>();
        for (Result result : resultScanner) {
            HBaseUtils.getInstance().parseResult(result, resultList);
        }
        System.out.println(resultList);
    }

    @Test
    public void testSingleColumnValueFilter() throws IOException {
        /**以course:math->90来过滤行*/
        byte[] family = Bytes.toBytes("course");
        byte[] qualifier = Bytes.toBytes("math");
        byte[] value = Bytes.toBytes("90");

        Scan scan = new Scan();
        /**
         * 如果某一行数据存值指定的参考列以及值相等，则结果中保留该行数据
         */
        SingleColumnValueFilter filter = new SingleColumnValueFilter(family, qualifier, CompareFilter.CompareOp.EQUAL, value);
//        filter.setFilterIfMissing(true);/**如果行中不存在参考列，结果中是否包含，默认包含（false）*/
        scan.setFilter(filter);

        ResultScanner resultScanner = TABLE.getScanner(scan);
        HBaseUtils.getInstance().printTheResultofResultScanner(resultScanner);
    }

    @Test
    public void testSingleColumnValueExcludeFilter() throws IOException {
        /**以course:math->90来过滤行*/
        byte[] family = Bytes.toBytes("course");
        byte[] qualifier = Bytes.toBytes("math");
        byte[] value = Bytes.toBytes("90");

        Scan scan = new Scan();
        /**
         * 对于SingleColumnValueFilter的结果去除参考列，即返回结果中不包含course:math->90的记录
         */
        SingleColumnValueExcludeFilter filter = new SingleColumnValueExcludeFilter(family, qualifier, CompareFilter.CompareOp.EQUAL, value);
        scan.setFilter(filter);

        ResultScanner resultScanner = TABLE.getScanner(scan);
        HBaseUtils.getInstance().printTheResultofResultScanner(resultScanner);
    }

    @Test
    public void testPrefixFilter() throws IOException {
        Scan scan = new Scan();
        /***/
        Filter filter = new PrefixFilter(Bytes.toBytes("No.009"));
        scan.setFilter(filter);
        HBaseUtils.getInstance().printTheResultofResultScanner(TABLE.getScanner(scan));
    }
}
