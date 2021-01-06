package myjdbc;

import java.sql.*;

/**
 * 查询所有的学生信息
 */
public class Demo6DQL {
    public static void main(String[] args) throws SQLException {
        //1) 得到连接对象
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/wolfManSql", "root", "2001");
        //2) 得到语句对象
        Statement statement = connection.createStatement();
        //3) 执行 SQL 语句得到结果集 ResultSet 对象
        ResultSet rs = statement.executeQuery("select * from stu01");
        //4) 循环遍历取出每一条记录
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            boolean gender = rs.getBoolean("gender");
            Date birthday = rs.getDate("birthday");
            //5) 输出的控制台上
            System.out.println("编号：" + id + ", 姓名：" + name + ", 性别：" + gender + ", 生日：" +
                    birthday);
        }
        //6) 释放资源
        rs.close();
        statement.close();
        connection.close();
    }
}