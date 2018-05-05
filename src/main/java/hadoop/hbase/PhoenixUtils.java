package hadoop.hbase;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/**
 * @Author: wuxiaobing
 * @Date 2018/2/5
 **/
@Slf4j
public class PhoenixUtils {
    private final String URL = "jdbc:phoenix:emr-header-1,emr-header-2";
    private final String DRIVERCLASS = "org.apache.phoenix.jdbc.PhoenixDriver";

    private PhoenixUtils() {
    }

    private static class Holder {
        private Holder() {
        }

        private static final PhoenixUtils instance = new PhoenixUtils();
    }

    public static synchronized PhoenixUtils getInstance() {
        return Holder.instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVERCLASS);
            conn = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return conn;
    }

    /***
     *查询HBase数据库
     */
    public static List<Map<String, String>> queryData(String sql) {
        List<Map<String, String>> list = new ArrayList<>();
        Connection conn = PhoenixUtils.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs == null) {
                    return Collections.EMPTY_LIST;
                }
                ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等
                int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数
                while (rs.next()) {
                    Map<String, String> rowData = new HashMap<>(columnCount);
                    for (int i = 1; i <= columnCount; i++) {
                        if (rs.getObject(i) instanceof BigDecimal) {
                            rowData.put(md.getColumnName(i), rs.getString(i).replaceAll(",", ""));
                        } else {
                            rowData.put(md.getColumnName(i), rs.getString(i));
                        }
                    }
                    list.add(rowData);
                }
            } catch (SQLException e) {
                log.error("fail to execute phoenix sql and parse result:{}", e.getMessage(), e);
            } finally {
                releaseStmt(rs, stmt, conn);
            }
        }
        return list;
    }

    /**
     * 释放查询连接
     */
    public static void releaseStmt(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                        conn = null;
                    }
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    public static void main(String[] args) {

        List<Map<String, String>> list = queryData("select * from DALARAN.VERSION_DEVICE_STAT limit 10");
        System.out.println(list);
    }
}
