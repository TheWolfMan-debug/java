import java.awt.*;
import javax.swing.*;

public class JFrameClass extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton[] button = new JButton[9];
    FlowLayout layout;

    public JFrameClass()
    {
        super("FlowLayout 应用举例");
        String lable;

        layout = new FlowLayout(FlowLayout.LEFT, 10,10);
        getContentPane().setLayout(layout);

        for(int i=0;i<9;i++)
        {
            lable = "Button#" +(i+1)+" ";
            button[i] = new JButton(lable);
            getContentPane().add(button[i]); 
        }
        setSize(320,320);
        setVisible(true);
        setResizable(false);
    }
    
}