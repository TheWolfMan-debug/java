package cn.itcast.travel.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckCodeUtils {

    public static boolean checkCode(HttpServletRequest request, HttpServletResponse response)
    {
        //验证校验
        String check = request.getParameter("check");
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次

        System.out.println("系统的验证码："+checkcode_server);
        System.out.println("输入的验证码："+check);
        System.out.println("验证码是否正确："+(checkcode_server != null && checkcode_server.equalsIgnoreCase(check)));

        return checkcode_server != null && checkcode_server.equalsIgnoreCase(check);
    }


}
