package myjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo11DML {
    public static void main(String[] args) throws SQLException {
//        insert();
        //update();
        delete();
    }

    //插入记录
    private static void insert() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into student values(5, ?, ?,?)");
        ps.setString(1, "小白龙");
        ps.setBoolean(2, true);
        ps.setDate(3, java.sql.Date.valueOf("1999-11-11"));
        int row = ps.executeUpdate();
        System.out.println("插入了" + row + "条记录");
        JdbcUtils.close(connection, ps);
    }

    //更新记录: 换名字和生日
    private static void update() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement("update student set name=?, birthday=?where id = ? ");
        ps.setString(1, "黑熊怪");
        ps.setDate(2, java.sql.Date.valueOf("1999-03-23"));
        ps.setInt(3, 5);
        int row = ps.executeUpdate();
        System.out.println("更新" + row + "条记录");
        JdbcUtils.close(connection, ps);
    }

    //删除记录: 删除第 5 条记录
    private static void delete() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement("delete from student where name=?");
        ps.setString(1, "小白龙");
        int row = ps.executeUpdate();
        System.out.println("删除了" + row + "条记录");
        JdbcUtils.close(connection, ps);
    }
}