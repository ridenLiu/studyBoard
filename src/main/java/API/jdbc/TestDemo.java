package API.jdbc;

import com.alibaba.druid.stat.DruidDataSourceStatManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mytest?serverTimezone=GMT";
        //  获取数据库连接
        Connection conne = DriverManager.getConnection(url,"root","mariadb");
        // 要执行的sql
        String sql = "select studentname from student";
        // 获取执行sql对象
        PreparedStatement ps = conne.prepareStatement(sql);
        // 结果集
        ResultSet rs = ps.executeQuery();
        // 储存结果的集合
        List<String> result = new ArrayList<>();
        while (rs.next()) {
            String studentname = rs.getString(1); // 可以是下标,也可以是字段名
            // 将结果放进集合
            result.add(studentname);
        }
        System.out.println(result);
    }

}
