package socket;
import java.io.*;
import java.net.*;


public class FileUpload_Client {
        public static void main(String[] args) throws IOException {
                // 1.创建流对象
                // 1.1 创建输入流,读取本地文件
                BufferedInputStream bis  = new BufferedInputStream(new FileInputStream("Demo\\src\\socket\\content.txt"));
                // 1.2 创建输出流,写到服务端
                Socket socket = new Socket("localhost", 6666);
                BufferedOutputStream   bos   = new BufferedOutputStream(socket.getOutputStream());

                //2.写出数据.
                byte[] b  = new byte[1024 * 8 ];
                int len ;
                while (( len  = bis.read(b))!=-1) {
                        bos.write(b, 0, len);
                        bos.flush();
                }
                // 关闭输出流,通知服务端,写出数据完毕
                socket.shutdownOutput();
                System.out.println("文件发送完毕");

                // 3. =====解析回写============
                InputStream in = socket.getInputStream();
                byte[] back = new byte[20];
                in.read(back);
                System.out.println(new String(back));
                in.close();

                // 3.释放资源
                bos.close();
                socket.close();
                bis.close();
                System.out.println("文件上传完毕 ");
        }
}
