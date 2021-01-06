package cloudStorage.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class sendRedUtils {
   public static void sendRedirect(HttpServletResponse response ,String path)
   {
       try {
           response.sendRedirect(path);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}
