package myjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo10List {
    public static void main(String[] args) throws SQLException {
        //创建一个集合
        List<Student> students = new ArrayList<>();
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from student");
        //没有参数替换
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            //每次循环是一个学生对象
            Student student = new Student();
            //封装成一个学生对象
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getBoolean("gender"));
            student.setBirthday(String.valueOf(resultSet.getDate("birthday")));
            //把数据放到集合中
            students.add(student);
        }
        //关闭连接
        JdbcUtils.close(connection, ps, resultSet);
        //使用数据
        for (Student stu : students) {
            System.out.println(stu);
        }
    }
}