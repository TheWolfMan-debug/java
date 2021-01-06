package myjdbc;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {

        //抛出类找不到的异常，注册数据库驱动
        Class.forName("lib.com.mysql.jdbc.Driver");
    }
}