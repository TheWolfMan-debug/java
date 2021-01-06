import javax.swing.*;

public class SimpleJFrameClass extends JFrame{



    /**
     *
     */
    private static final long serialVersionUID = 1L;

    SimpleJFrameClass panel;

    public static final int DEFAULT_WIDTH = 320;
    public static final int DEFAULT_HEIGHT = 120;

    public SimpleJFrameClass() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("用户登录");
        panel = new SimpleJFrameClass();
        getContentPane().add(panel);
        setVisible(true);
        setResizable(false);

    }

    
}