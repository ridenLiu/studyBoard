package API.jdbc;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class TestDemo2 {
    /**
     * ## 单数据源可以直接写:url, 多数据源:jdbc-url
     * jdbc-url: jdbc:oracle:thin:@(description=(address=(host=localhost)(protocol=tcp)(port=1521))(connect_data=(service_name=ORCL)(server=DEDICATED))))
     * username: RIDEN
     * password: SSH
     * driver-class-name: oracle.jdbc.driver.OracleDriver
     * type: com.alibaba.druid.pool.DruidDataSource
     */

    static String sql = "select * from student";
    static String url = "jdbc:oracle:thin:@(description=(address=(host=localhost)(protocol=tcp)(port=1521))(connect_data=(service_name=ORCL)(server=DEDICATED))))";
    static String username = "RIDEN";
    static String password = "SSH";

    public static void main(String[] args) throws SQLException {
        CustomizedSqlExecutor cse = new CustomizedSqlExecutor(handleConnection(), sql);
        List<Map<String, String>> res = cse.executeQuery();
        System.out.println(res);
    }

    public static Connection handleConnection() {
        String url = "jdbc:oracle:thin:@(description=(address=(host=localhost)(protocol=tcp)(port=1521))(connect_data=(service_name=ORCL)(server=DEDICATED))))";
        String username = "RIDEN";
        String password = "SSH";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("数据库连接失败!");
            e.printStackTrace();
        }
        return conn;
    }

    public void customizedSqlExecutor(String sql) throws SQLException {
        Connection conn = handleConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        // 获取数据库元数据
        ResultSetMetaData rsd = rs.getMetaData();
    }


}
