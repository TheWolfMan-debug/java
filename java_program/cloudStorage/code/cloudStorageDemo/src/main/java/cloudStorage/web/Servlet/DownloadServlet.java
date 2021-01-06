package cloudStorage.web.Servlet;

import cloudStorage.domain.User;
import cloudStorage.util.DownLoadUtils;
import cloudStorage.util.sendRedUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@WebServlet("/userDownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取文件名称
        String filename = request.getParameter("filename");
        //获取用户将要下载文件的文件夹名
        String currentFileDir = request.getParameter("currentFileDir");
        //获取当前用户信息
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        //获取session对象
        HttpSession session = request.getSession();
        //获取ServletContext
        ServletContext servletContext = this.getServletContext();
        //保存编码前的文件名
        String preCodeFilename = filename;


        //-------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------

        //实例化一个工具类
        DownLoadUtils downLoadUtils = new DownLoadUtils(response, servletContext);
        //获得文件名
        filename = downLoadUtils.searchFilename(currentUser, currentFileDir, filename);

        //-------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------


        //创建文件对象
        String downloadFile = servletContext.getRealPath("WEB-INF/userResources/" + currentUser.getUsername() + "/" + currentFileDir + "/" + filename);
        //如果没有文件，则返回主菜单界面
        if (!(new File(downloadFile).exists()) || "".equals(filename)) {
            sendRedUtils.sendRedirect(response, "/wolf/menuPage.html");
            return;
        }

        //用字节流关联
        FileInputStream fis = new FileInputStream(downloadFile);
        //文件流的大小
        double downloadFileLength = fis.available();

        //设置response的响应头
        //设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type", mimeType);
        //设置响应头打开方式:content-disposition

        //解决中文文件名问题
        //1.获取user-agent请求头、
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);
        //设置相应头，以附件方式打开
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        //初始化下载进度，为未完成
        session.setAttribute("isEndDownload", "fail");

        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();


        byte[] buff;
        //累计传输的字节
        double sum = 0;
        int len;
        //判断当前用户是否为vip
        long startTime = System.currentTimeMillis();
        if (currentUser.getVip()) {
            //加速
            buff = new byte[1024 * 8];
            //下载文件
            while ((len = fis.read(buff)) != -1) {
                sos.write(buff, 0, len);
                try {
                    Thread.sleep(10); //睡眠
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum += len;
                //下载进度
                System.out.println(sum / downloadFileLength);
                //将下载进度保存到session中
                session.setAttribute("currentDownloadProgress", sum / downloadFileLength);

            }
        } else {
            //减速
            buff = new byte[1024];
            //下载文件
            while ((len = fis.read(buff)) != -1) {
                try {
                    Thread.sleep(20); //睡眠
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sos.write(buff, 0, len);
                sum += len;
                System.out.println(sum / downloadFileLength);
                //保存下载进度
                session.setAttribute("currentDownloadProgress", sum / downloadFileLength);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("所用时间：" + (endTime - startTime));

        //如果下载完成，将下载进度置为成功
        session.setAttribute("isEndDownload", "success");
        //关闭流
        fis.close();

        //-------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------------------

        //存储用户下载历史
        downLoadUtils.saveUserHistory(currentUser, preCodeFilename);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
