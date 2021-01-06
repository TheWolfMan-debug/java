package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 向学生表中添加 4 条记录，主键是自动增长
 */
public class Demo5DML {
    public static void main(String[] args) throws SQLException {
// 1) 创建连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql:///wolfManSql", "root",
                "2001");
// 2) 创建 Statement 语句对象
        Statement statement = connection.createStatement();
// 3) 执行 SQL 语句：executeUpdate(sql)
        int count = 0;
// 4) 返回影响的行数
        count += statement.executeUpdate("insert into student values(1, '孙悟空', 1, '1993-03-24 ')");
        count += statement.executeUpdate("insert into student values(2, '白骨精', 0, '1995-03-24 ')");
        count += statement.executeUpdate("insert into student values(3, '猪八戒', 1, '1903-03-24 ')");
        count += statement.executeUpdate("insert into student values(4, '嫦娥', 0, '1993-03-11 ')");
        System.out.println("插入了" + count + "条记录");
// 5) 释放资源
        statement.close();
        connection.close();
    }
}