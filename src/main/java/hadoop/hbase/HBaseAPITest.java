package hadoop.hbase;

import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * @Author: wuxiaobing
 * @Date 2018/1/31
 **/
public class HBaseAPITest {
    private static final String TABLE_NAME = "studentinfo";

    private static final Table TABLE = HBaseUtils.getInstance().getTable(TABLE_NAME);

    /**
     * 测试客户端缓存
     *
     * @throws IOException
     */
    @Test
    public void testClientFlush() throws IOException {
        String rowKey = "No.013";

        HTable table = (HTable) TABLE;
        Put put = new Put(Bytes.toBytes(rowKey));
        //启用客户端缓存
        table.setAutoFlush(false, true);
        Map<String, String> data1 = new HashMap<>();
        put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("LinTT"));
        put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes("27"));
        table.put(put);

        Get get = new Get(Bytes.toBytes(rowKey));
        Result result1 = table.get(get);
        System.out.println("the results is:" + result1.toString());

        table.flushCommits();

        Result result2 = table.get(get);
        System.out.println("the results is:" + result1.toString());
    }

    /**
     * 插入错误的列族的示范，会报RetriesExhaustedWithDetailsException异常
     * 对应正确的行会执行，错误的行会报错（如插入rowkey为"No.015"的数据正确）
     */
    @Test
    public void testInsertWrongData() {
        try {
            List<Put> putsList = new ArrayList<>();
            Put put1 = new Put(Bytes.toBytes("No.014"));
            put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("LinTT"));
            put1.addColumn(Bytes.toBytes("wrongfami"), Bytes.toBytes("age"), Bytes.toBytes("27"));
            Put put2 = new Put(Bytes.toBytes("No.015"));
            put2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("HeHe"));
            put2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes("27"));

            putsList.add(put1);
            putsList.add(put2);

            TABLE.put(putsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入空的put会造成异常
     */
    @Test
    public void testInsertNullPut() {
        Put put = new Put(Bytes.toBytes("No.014"));
        HTable hTable = (HTable) TABLE;
        try {
            hTable.put(put);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteByRowKey() {
        HBaseUtils.getInstance().delete(TABLE_NAME, "row1");
    }

    /**
     * 用于检测checkAndPut方法
     */
    @Test
    public void testCheckAndPut() throws IOException {
        Put put1 = new Put(Bytes.toBytes("row1"));
        put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("qual1"), Bytes.toBytes("val1"));

        /**这里value:null表示只要指定的列的值不存在就插入*/
        boolean res1 = TABLE.checkAndPut(Bytes.toBytes("row1"), Bytes.toBytes("info"), Bytes.toBytes("qual1"), null, put1);
        /**如果{row1:(info:qual1)}不存在值，则res1为true*/
        System.out.println("res1:" + res1);

        boolean res2 = TABLE.checkAndPut(Bytes.toBytes("row1"), Bytes.toBytes("info"), Bytes.toBytes("qual1"), null, put1);
        /**{row1:(info:qual1)}列已经插入值了，所以这里必须为false*/
        System.out.println("res2:" + res2);

        Put put2 = new Put(Bytes.toBytes("row1"));
        put2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("qual2"), Bytes.toBytes("val2"));

        /**如果{row1:(info:qual1)}列存在值val1则为true否则为false*/
        boolean res3 = TABLE.checkAndPut(Bytes.toBytes("row1"), Bytes.toBytes("info"), Bytes.toBytes("qual1"), Bytes.toBytes("val1"), put2);
        System.out.println("res3:" + res3);

        /**因为{row1:(info:qual1)}列的值不是val2，所以结果为false*/
        boolean res3_1 = TABLE.checkAndPut(Bytes.toBytes("row1"), Bytes.toBytes("info"), Bytes.toBytes("qual1"), Bytes.toBytes("val2"), put2);
        System.out.println("res3_1:" + res3_1);

//        Put put3 = new Put(Bytes.toBytes("row2"));
//        put3.addColumn(Bytes.toBytes("info"), Bytes.toBytes("qual1"), Bytes.toBytes("val3"));
//        /**此处会报错，因为标胶的不是同一行的数据（即不是同一rowey）*/
//        boolean res4 = TABLE.checkAndPut(Bytes.toBytes("row1"), Bytes.toBytes("info"), Bytes.toBytes("qual1"), Bytes.toBytes("val1"), put3);
//        System.out.println("res4:" + res4);
    }

    @Test
    public void testGet() throws IOException {
        Get get = new Get(Bytes.toBytes("row1"));
        /**获得{row1:(info:qual1)}的值*/
        get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("qual1"));
        Result result = TABLE.get(get);
        System.out.println(Bytes.toString(result.value()));

        Get get1 = new Get(Bytes.toBytes("No.001"));
        /**限制只能获得指定列族下的数据*/
        get1.addFamily(Bytes.toBytes("info"));
        Result result1 = TABLE.get(get1);
        System.out.println(result1);

        Get get2 = new Get(Bytes.toBytes("No.001"));
        get2.addFamily(Bytes.toBytes("info"));
        Set<byte[]> set = get2.familySet();
        for (byte[] bytes : set) {
            System.out.println(Bytes.toString(bytes));
        }
    }

    @Test
    public void testResult() throws IOException {
        String rowKey = "No.001";
//        Get get = new Get(Bytes.toBytes(rowKey));
//        Result result = TABLE.get(get);
//        NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> resultMap = result.getMap();
//        for (Map.Entry<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> famlEntry : resultMap.entrySet()) {
//            for (Map.Entry<byte[], NavigableMap<Long, byte[]>> qualEntry : famlEntry.getValue().entrySet()) {
//                for (Map.Entry<Long, byte[]> valueEntry : qualEntry.getValue().entrySet()) {
//                    System.out.println(rowKey + ":<" + Bytes.toString(famlEntry.getKey()) + ":" + Bytes.toString(qualEntry.getKey()) + ">:" + valueEntry.getKey() + "-->" + Bytes.toString(valueEntry.getValue()));
//                }
//            }
//        }
        System.out.println(HBaseUtils.getInstance().getResultByTableAndRowKey(TABLE_NAME, rowKey));
    }

    /**
     * 测试删除delete集合
     *
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException {
        List<Delete> deleteList = new ArrayList<>();

        Delete delete1 = new Delete(Bytes.toBytes("row1"));
        delete1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("qual1"));
        delete1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("qual2"));
        deleteList.add(delete1);

        Delete delete2 = new Delete(Bytes.toBytes("No.015"));
        delete2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"));
        delete2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));
        deleteList.add(delete2);

        TABLE.delete(deleteList);
    }


    /**
     * 进行批量操作
     *
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testBatch() throws IOException, InterruptedException {
        List<Row> batch = new ArrayList<>();

        Put put1 = new Put(Bytes.toBytes("row1"));
        put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("wuxiaobing"));
        Put put2 = new Put(Bytes.toBytes("row1"));
        put2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes("27"));
        batch.add(put1);
        batch.add(put2);

        Get get1 = new Get(Bytes.toBytes("row1"));
        get1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));
        Get get2 = new Get(Bytes.toBytes("row1"));
        get2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"));
        batch.add(get1);
        batch.add(get2);

        Delete delete1 = new Delete(Bytes.toBytes("row1"));
        delete1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));
        Delete delete2 = new Delete(Bytes.toBytes("row1"));
        delete1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"));
        batch.add(delete1);
        batch.add(delete2);

        Object[] batchResults = new Object[batch.size()];
        TABLE.batch(batch, batchResults);
        for (Object result : batchResults) {
            System.out.println(result);
        }
    }

    @Test
    public void testScan() throws IOException {
        int count = 0;
        /**设置rowKey的起始位置*/
        Scan scan = new Scan(Bytes.toBytes("No.001"), Bytes.toBytes("No.013"));
        //设置合适的值可以进行缓存和批量处理，从而减少RPC请求
//        scan.setCaching(1);
//        scan.setBatch(1);
        /**获得结果的迭代器*/
        ResultScanner resultScanner = TABLE.getScanner(scan);
        /**每循环一次都会经历一次RPC调用*/
        for (Result result : resultScanner) {
            /**通过rowKey来获得每一行的内容*/
            List<Map<String, String>> scanResults = HBaseUtils.getInstance().getResultFromTableByRowKey(TABLE, Bytes.toString(result.getRow()));
            System.out.println(scanResults);
            count++;
        }
        System.out.println("the num of RPCs:" + count);
        resultScanner.close();
    }
}
