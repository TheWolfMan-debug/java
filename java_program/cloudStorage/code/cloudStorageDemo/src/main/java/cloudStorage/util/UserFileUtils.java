package cloudStorage.util;

import cloudStorage.domain.User;

import javax.servlet.ServletContext;
import java.io.File;

public class UserFileUtils {
    private User user;
    private ServletContext servletContext;

    public UserFileUtils() {
    }

    public UserFileUtils(User user, ServletContext servletContext) {
        this.user = user;
        this.servletContext = servletContext;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String createUserSaveDir(String path)
    {
        //创建上传文件的保存目录，为了安全建议在WEB-INF目录下，用户无法访问
        String uploadPath = servletContext.getRealPath("WEB-INF/userResources/" + this.user.getUsername()+path);//获取上传文件的保存路径
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();//如果目录不存在就创建这样一个目录
        }
        return uploadPath;
    }

    public File createUserSaveDir()
    {
        //创建上传文件的保存目录，为了安全建议在WEB-INF目录下，用户无法访问
        String uploadPath = servletContext.getRealPath("WEB-INF/userResources/" + this.user.getUsername());//获取上传文件的保存路径
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();//如果目录不存在就创建这样一个目录
        }
        return uploadFile;
    }

    public File createUserTmpDir()
    {
        //临时文件
        //临时路径，如果上传的文件超过预期的大小，我们将它存放到一个临时目录中，过几天自动删除，或者提醒用户转存为永久
        String tmpPath = servletContext.getRealPath("WEB-INF/tmp/" + this.user.getUsername());
        File file = new File(tmpPath);
        if (!file.exists()) {
            file.mkdirs();//如果目录不存在就创建这样临时目录
        }
        return file;
    }


}
