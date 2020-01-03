package API.jdbc;

import com.alibaba.fastjson.JSONArray;
import oracle.sql.TIMESTAMP;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomizedSqlExecutor {
    private String url;
    private String username;
    private String password;
    private String sql;
    private Connection connection;
    private ResultSet rs;

    public CustomizedSqlExecutor(String url, String username, String password, String sql) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.sql = sql;
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CustomizedSqlExecutor(Connection connection, String sql) {
        this.connection = connection;
        this.sql = sql;
    }

    /**
     * 执行执行查询sql并返回List<Map<String,String>>类型数据
     *
     * @throws SQLException
     */
    public List<Map<String, String>> executeQuery() throws SQLException {
        List<Map<String, String>> resList = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(sql);
        this.rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        while (rs.next()) {
            Map<String, String> singleMap = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                int typeId = rsmd.getColumnType(i);
                Object obj = rs.getObject(i);
                String value = getDataStrByType(typeId, obj);
                String key = rsmd.getColumnName(i);
                singleMap.put(key, value);
            }
            resList.add(singleMap);
        }
        return resList;
    }


    private String getDataStrByType(int type, Object obj) {
        String dateStr = null;
        switch (type) {
            case 91: {// java.sql.Date
                Date resDate = (java.sql.Date) obj;
                LocalDate date = resDate.toLocalDate();
                dateStr = date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                break;
            }
            case 92: {// java.sql.Time
                java.sql.Time resDate = (Time) obj;
                LocalTime time = resDate.toLocalTime();
                dateStr = time.format(DateTimeFormatter.ISO_LOCAL_TIME);
                break;
            }
//            case 93: {
//                // java.sql.Timestamp类型的
//                break;
//            }
            default: {
                if (obj != null) {
                    dateStr = obj.toString();
                }
            }
        }
        return dateStr;
    }

    /**
     * 关闭数据库的连接
     */
    public void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
