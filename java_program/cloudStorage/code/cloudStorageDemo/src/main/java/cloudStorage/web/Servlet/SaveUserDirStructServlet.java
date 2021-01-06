package cloudStorage.web.Servlet;

import cloudStorage.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

@WebServlet("/saveUserDirStructServlet")
public class SaveUserDirStructServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应格式
        response.setContentType("application/json;charset=utf-8");
        //获取session
        HttpSession session = request.getSession();
        //获取当前用户
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        //获取servletContext
        ServletContext servletContext = this.getServletContext();

        //1.创建ObjectInputStream对象,构造方法中传递字节输入流
        ObjectInputStream is = null;
        ObjectInputStream isIndex = null;
        Object l = null;
        Object lIndex = null;

        //获取当前用户的文件路径
        String realDownloadPath = servletContext.getRealPath("WEB-INF/userResources/" + currentUser.getUsername() + "/");
        File file = new File(realDownloadPath + "userDirsStruct.txt");
        //获取索引文件
        File fileIndex =new File(realDownloadPath + "userDirsStructIndex.txt");


        //反序列化
        try {
            //用户结构文件
            FileInputStream fileInputStream = new FileInputStream(file);
            is = new ObjectInputStream(fileInputStream);

            //索引文件
            FileInputStream fileIndexInputStream = new FileInputStream(fileIndex);
            isIndex = new ObjectInputStream(fileIndexInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            l = is.readObject();
            lIndex = isIndex.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                is.close();
                isIndex.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        LinkedHashMap<String, LinkedList<String>> h = (LinkedHashMap<String, LinkedList<String>>) l;

        LinkedList<String> hIndex = (LinkedList<String>)lIndex;


        //判断为文件夹还是文件
        System.out.println("是否是文件夹" + request.getParameter("isDir"));

        //如果是文件夹
        if ("true".equals(request.getParameter("isDir"))) {
            System.out.println("用户目录：");
            String userDirName = request.getParameter("userDirName");

            h.put(userDirName, new LinkedList<>());
            hIndex.add(userDirName);
            System.out.println("更新后的索引文件："+hIndex);
        } else {
            System.out.println("用户文件：");
            //将当前用户文件目录通过session保存
            session.setAttribute("currentUserDir",request.getParameter("parentName"));
            //获取当前文件的目录
            String parentName = request.getParameter("parentName");
            //获取文件名
            String userFileStructName = request.getParameter("userDirName");
            //获取文件目录下的文件列表
            LinkedList<String> userFileName = h.get(parentName);
            //添加文件
            userFileName.add(userFileStructName);
            //更新目录下的文件
            h.put(parentName, userFileName);
        }


        //序列化，存储数据
        ObjectOutputStream oos = null;
        ObjectOutputStream oosIndex = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oosIndex = new ObjectOutputStream(new FileOutputStream(fileIndex));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //使用ObjectOutputStream对象中的方法writeObject,把对象写入到文件中
        try {
            oos.writeObject(h);
            oosIndex.writeObject(hIndex);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {        //释放资源
            try {
                oos.close();
                oosIndex.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //回写数据
        Map<String,Object> map = new HashMap<>();

        //将map转为json，并且传递给客户端
        ObjectMapper mapper = new ObjectMapper();
        //并且传递给客户端
        mapper.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
