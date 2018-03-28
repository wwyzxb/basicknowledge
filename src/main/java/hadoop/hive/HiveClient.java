package hadoop.hive;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.thrift.TException;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HiveClient {
    @Test
    public void testPrintDB() throws TException {
        HiveConf hiveConf = new HiveConf();
//        hiveConf.setVar(HiveConf.ConfVars.METASTOREURIS, "thrift://emr-header-1:9083");
        hiveConf.addResource("hive-site.xml");
        IMetaStoreClient client = new HiveMetaStoreClient(hiveConf);
        List<String> databases = client.getAllDatabases();
        if (databases != null && databases.size() != 0) {
            System.out.println(databases.get(0));
        }
    }

    @Test
    public void testPrintTables() throws TException {
        HiveConf hiveConf = new HiveConf();
        hiveConf.setVar(HiveConf.ConfVars.METASTOREURIS, "thrift://emr-header-1:9083");
        IMetaStoreClient client = new HiveMetaStoreClient(hiveConf);
        /**1.获得所有的数据库*/
        List<String> dbNames = client.getAllDatabases();
        List<Table> hiveTableList = Lists.newArrayList();
        Map<String, Map<String, String>> hiveTables = Maps.newHashMap();
        List<Table> phoenixTableList = Lists.newArrayList();
        Map<String, Map<String, String>> phoenixTables = Maps.newHashMap();
        for (String dbName : dbNames) {
            /**2.获得数据库中所有的表*/
            List<String> tableNames = client.getAllTables(dbName);
            for (String tableName : tableNames) {
                /**3.通过库名和表名获得表实体*/
                Table table = client.getTable(dbName, tableName);//获得表实体
                /**4.判断当前的表是否为phoenix表*/
                if ("com.nubia.stat.hive.NubiaPhoenixStorageHandler".equals(table.getParameters().get("storage_handler"))) {
                    phoenixTableList.add(table);
                    praseCols(table, phoenixTables);
                } else {
                    hiveTableList.add(table);
                    praseCols(table, hiveTables);
                }
            }
        }

        System.out.println(hiveTables.size() + ":" + phoenixTables.size());
    }

    private void praseCols(Table table, Map<String, Map<String, String>> result) {
        if (table == null) return;
        if (table == result) return;
        String fullName = table.getDbName() + "." + table.getTableName();
        if (table.getParameters().containsKey("phoenix.table.name")) {
            fullName = table.getParameters().get("phoenix.table.name");
        }
        Map<String, String> cols = Maps.newHashMap();
        Iterator<FieldSchema> iterator = table.getSd().getColsIterator();
        while (iterator.hasNext()) {
            FieldSchema fieldSchema = iterator.next();
            cols.put(fieldSchema.getName(), fieldSchema.getType());
        }
        if ("com.nubia.stat.hive.NubiaPhoenixStorageHandler".equals(table.getParameters().get("storage_handler"))) {
            cols = replaceColNames(cols, table);
        }
        result.put(fullName, cols);
    }

    private Map<String, String> replaceColNames(Map<String, String> cols, Table table) {
        String colsMapValue = table.getParameters().get("phoenix.column.mapping").replaceAll("\n", "").replaceAll(" ", "").replaceAll("\r", "");
        String[] pairs = colsMapValue.split(",");
        Map<String, String> newCols = Maps.newHashMap();
        for (String pair : pairs) {
            String[] colMap = pair.split(":");
            String hiveCol = colMap[0];
            String phoenixCol = colMap[1];
            if (cols.get(hiveCol) == null) {
                System.out.println(cols.get(hiveCol));
            }
            newCols.put(phoenixCol, cols.get(hiveCol));
        }
        return newCols;
    }
}