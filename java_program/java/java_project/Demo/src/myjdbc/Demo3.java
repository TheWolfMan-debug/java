package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo3 {
    public static void main(String[] args) throws SQLException {
        //url 连接字符串
        String url = "jdbc:mysql://localhost:3306/wolfmansql";
        //属性对象
        Properties info = new Properties();
        //把用户名和密码放在 info 对象中

        info.setProperty("user", "root");
        info.setProperty("password", "2001");
        Connection connection = DriverManager.getConnection(url, info);
        //com.mysql.jdbc.JDBC4Connection@68de145
        System.out.println(connection);
    }
}