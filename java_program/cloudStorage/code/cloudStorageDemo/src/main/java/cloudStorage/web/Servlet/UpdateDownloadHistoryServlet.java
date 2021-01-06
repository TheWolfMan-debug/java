package cloudStorage.web.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/updateDownloadHistoryServlet")
public class UpdateDownloadHistoryServlet extends HttpServlet {
    //记录用户下载进度
    private static double preDownloadProgress = -1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的数据格式为json
        response.setContentType("application/json;charset=utf-8");

        //获取session
        HttpSession session = request.getSession();
        //获取是否完成下载的标志
        String isEndDownload = (String) session.getAttribute("isEndDownload");

        //获取当前用户文件下载进度
        double currentDownloadProgress = (double) session.getAttribute("currentDownloadProgress");

        //打印preDownloadProgress及currentDownloadProgress
//        System.out.println("preDownloadProgress：" + preDownloadProgress);
//        System.out.println("currentDownloadProgress：" + currentDownloadProgress);
        //如果preDownloadProgress != currentDownloadProgress则证明还在下载中
        //否则用户已经取消了下载，则将isEndDownload置为cancel
        if (preDownloadProgress != currentDownloadProgress) {
            preDownloadProgress = currentDownloadProgress;
        } else {
            preDownloadProgress = -1;
            isEndDownload = "cancel";
        }

        System.out.println("当前文件是否下载成功：" + isEndDownload);

        //创建map集合，回写数据
        Map<String, Object> map = new HashMap<>();
        map.put("isEndDownload", isEndDownload);
        //将map转为json，并且传递给客户端
        ObjectMapper mapper = new ObjectMapper();
        //并且传递给客户端
        mapper.writeValue(response.getWriter(), map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
