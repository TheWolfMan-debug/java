package myjdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo9Student {
    public static void main(String[] args) throws SQLException {
        //创建学生对象
        Student student = new Student();
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from student where id=?");
        //设置参数
        ps.setInt(1, 2);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            //封装成一个学生对象
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getBoolean("gender"));
            student.setBirthday(String.valueOf(resultSet.getDate("birthday")));
        }
        //释放资源
        JdbcUtils.close(connection, ps, resultSet);
        //可以数据
        System.out.println(student);
    }
}