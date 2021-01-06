package webSocket;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket socket = server.accept();
            new Thread(new Web(socket)).start();
        }
    }

    static class Web implements Runnable {
        private Socket socket;

        public Web(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                //转换流,读取浏览器请求第一行
                BufferedReader readWb = new
                        BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = readWb.readLine();
                //取出请求资源的路径
                String[] strArr = request.split(" ");
                System.out.println("输出第一行的信息：");
                System.out.println(Arrays.toString(strArr));
                String path = strArr[1].substring(1);
                System.out.println("输出文件路径：");
                System.out.println(path);
                File file = new File(path);

                if (file.isFile()) {
                    FileInputStream fis = new FileInputStream(file);
                    System.out.println("打印文件输入流：");
                    System.out.println(fis);
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    //向浏览器 回写数据
                    OutputStream out = socket.getOutputStream();
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                    out.write("Content-Type:text/html\r\n".getBytes());
                    out.write("\r\n".getBytes());
                    while ((len = fis.read(bytes)) != -1) {
                        out.write(bytes, 0, len);
                    }
                    fis.close();
                    out.close();
                }

                readWb.close();
                socket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}