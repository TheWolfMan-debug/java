package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * c3p0的演示
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象
        DataSource ds  = new ComboPooledDataSource();
        //2. 获取连接对象
        Connection conn = ds.getConnection();

        String sql = "insert into account values(5,?,?)";

        PreparedStatement prep = conn.prepareStatement(sql);

        prep.setString(1,"xiaoHong");
        prep.setDouble(2,3000);



        int i = prep.executeUpdate();
        System.out.println("影响了"+i+"行");

        //3. 打印
        System.out.println("打印信息："+conn);

    }
}
