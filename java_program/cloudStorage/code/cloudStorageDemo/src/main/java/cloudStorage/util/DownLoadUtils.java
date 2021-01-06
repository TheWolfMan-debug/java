package cloudStorage.util;

//import sun.misc.BASE64Encoder;
import cloudStorage.domain.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.LinkedList;


public class DownLoadUtils {

    private HttpServletResponse response;
    private ServletContext servletContext;


    public DownLoadUtils(HttpServletResponse response, ServletContext servletContext) {
        this.response = response;
        this.servletContext = servletContext;
    }


    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            System.out.println("这是火狐！！！");
//            BASE64Encoder base64Encoder = new BASE64Encoder();
//            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }


    public String searchFilename( User currentUser, String currentFileDir,String filename)
    {
        //在用户目录下查找文件
        String recordRealDownloadPath = this.servletContext.getRealPath("WEB-INF/userResources/" + currentUser.getUsername() + "/" + currentFileDir);
        File recordFile = new File(recordRealDownloadPath);
        //如果目录不存在，返回主菜单界面
        if (!recordFile.exists()) {
            sendRedUtils.sendRedirect(this.response,"/wolf/menuPage.html");
        }

        //遍历文件夹，获取文件名及后缀名
        String[] fileLists = recordFile.list();
        for (String currentDirFile : fileLists) {
            if (currentDirFile.substring(0, currentDirFile.indexOf('.')).equals(filename)) {
                return currentDirFile;
            }
        }

        return null;
    }


    public void saveUserHistory(User currentUser,String preCodeFilename)
    {
        //下载时记录用户下载的文件历史
        //创建ObjectInputStream对象,构造方法中传递字节输入流
        ObjectInputStream is = null;
        Object l = null;

        //获取当前用户的文件路径
        String realDownloadPath = this.servletContext.getRealPath("WEB-INF/userResources/" + currentUser.getUsername() + "/");

        File file = new File(realDownloadPath + "DownloadRecord.txt");

        //反序列化
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            is = new ObjectInputStream(fileInputStream);
            //2.使用ObjectInputStream对象中的方法readObject读取保存对象的文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            l = is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3.释放资源
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        LinkedList<String> h = (LinkedList<String>) l;
        //将文件名写入，添加数据
        h.addFirst(preCodeFilename);

        //序列化，存储数据
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //使用ObjectOutputStream对象中的方法writeObject,把对象写入到文件中
        try {
            oos.writeObject(h);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {        //释放资源
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


//    public void downUserFile(User currentUser, FileInputStream fis, ServletOutputStream sos, HttpSession session,String preCodeFilename)throws Exception
//    {
//        byte[] buff;
//        //累计传输的字节
//        double sum = 0;
//        int len;
//        double downloadFileLength = fis.available();
//        //判断当前用户是否为vip
//        if (currentUser.getVip()) {
//            //加速
//            buff = new byte[1024 * 8];
//            //下载文件
//            while ((len = fis.read(buff)) != -1) {
//                sos.write(buff, 0, len);
//                try {
//                    Thread.sleep(10); //睡眠
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                sum += len;
//                //下载进度
//                System.out.println(sum / downloadFileLength);
//                //将下载进度保存到session中
//                session.setAttribute("currentDownloadProgress", sum / downloadFileLength);
//                if(sum/downloadFileLength==1)
//                {
//                    //如果下载完成，将下载进度置为成功
//                    session.setAttribute("isEndDownload", "success");
//                }
//
//            }
//        } else {
//            //减速
//            buff = new byte[1024];
//            //下载文件
//            while ((len = fis.read(buff)) != -1) {
//                try {
//                    Thread.sleep(20); //睡眠
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                sos.write(buff, 0, len);
//                sum += len;
//                System.out.println(sum / downloadFileLength);
//                //保存下载进度
//                session.setAttribute("currentDownloadProgress", sum / downloadFileLength);
//                if(sum/downloadFileLength==1)
//                {
//                    //如果下载完成，将下载进度置为成功
//                    session.setAttribute("isEndDownload", "success");
//                }
//
//            }
//        }
//
//        //存储用户下载历史
//        this.saveUserHistory(currentUser, preCodeFilename);
//    }
}
