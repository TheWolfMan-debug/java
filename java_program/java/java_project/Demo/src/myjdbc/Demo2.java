package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 得到连接对象
 */
public class Demo2 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/wolfmansql";
        //1) 使用用户名、密码、URL 得到连接对象
        Connection connection = DriverManager.getConnection(url, "root", "2001");
        //com.mysql.jdbc.JDBC4Connection@68de145
        System.out.println(connection);
    }
}