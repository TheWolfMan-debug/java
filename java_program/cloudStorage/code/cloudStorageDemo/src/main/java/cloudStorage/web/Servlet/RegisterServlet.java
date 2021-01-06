package cloudStorage.web.Servlet;

import cloudStorage.domain.User;
import cloudStorage.service.impl.UserServiceImpl;
import cloudStorage.util.UserFileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的数据格式为json
        response.setContentType("application/json;charset=utf-8");

        //获取注册时的用户名，密码，是否为vip等信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String isVip = request.getParameter("vip");

        //判断是否为vip
        Boolean vip="yes".equals(isVip);

        //实例化一个userServiceImpl
        UserServiceImpl userService = new UserServiceImpl();
        //实例化一个用户
        User newUser = new User(username, password, vip);
        //注册
        Boolean result = userService.register(newUser);

        //回写数据
        Map<String, Object> map = new HashMap<>();

        //判断是否注册成功
        if (result) {
            //注册失败
            map.put("registerResult", true);
            map.put("msg", "注册成功");
        } else {
            //注册成功
            map.put("registerResult", false);
            map.put("msg", "注册失败");
        }

        //将map转为json，并且传递给客户端
        ObjectMapper mapper = new ObjectMapper();
        //并且传递给客户端
        mapper.writeValue(response.getWriter(), map);


        //实例化一个工具类
        UserFileUtils userFileUtils = new UserFileUtils(newUser, this.getServletContext());
        //调用创建用户目录的的方法
        userFileUtils.createUserSaveDir();
        //创建tmp目录
        userFileUtils.createUserTmpDir();


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
