package myjdbc;

import java.sql.*;

/**
 * 创建一张学生表
 */
public class Demo4DDL {
    public static void main(String[] args) {
        //1. 创建连接
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///wolfManSql", "root", "2001");
            //2. 通过连接对象得到语句对象
            statement = conn.createStatement();
            //3. 通过语句对象发送 SQL 语句给服务器
            //4. 执行 SQL
            int i = statement.executeUpdate("create table stu01 (id int PRIMARY key auto_increment, " +
                    "name varchar(20) not null, gender boolean, birthday date)");
            System.out.println(i);
            //5. 返回影响行数(DDL 没有返回值)
            System.out.println("创建表成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //6. 释放资源
        finally {
            //关闭之前要先判断
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}