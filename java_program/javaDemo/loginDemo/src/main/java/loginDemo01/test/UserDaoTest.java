package loginDemo01.test;

import loginDemo01.dao.UserDao;
import loginDemo01.domain.User;
import org.junit.Test;

public class UserDaoTest {



    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("superbaby");
        loginuser.setPassword("123111");


        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
