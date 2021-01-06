package myjdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo7Login {
    //从控制台上输入的用户名和密码
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        login(name, password);
    }

    /**
     * 登录的方法
     */
    public static void login(String name, String password) {
        //a) 通过工具类得到连接
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            //b) 创建语句对象，使用拼接字符串的方式生成 SQL 语句
            statement = connection.createStatement();
            //c) 查询数据库，如果有记录则表示登录成功，否则登录失败
            String sql = "select * from user where name='" + name + "' and password='" + password
                    + "'";
            System.out.println(sql);
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                System.out.println("登录成功，欢迎您：" + name);
            } else {
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //d) 释放资源
            JdbcUtils.close(connection, statement, rs);
        }
    }
}