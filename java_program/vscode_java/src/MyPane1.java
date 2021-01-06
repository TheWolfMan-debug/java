// import java.awt.*;
// import javax.swing.*;

// public class MyPane1 extends JPane1 {
//     public static final int DEFAULT_WIDTH = 300;
//     public static final int DEFAULT_HEIGHT = 300;

//     public MyPane1(){
//         setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
//     }

//     protected void paintCpmponent(Graphics g){
//         super.paintComponent(g);
//         Graphics2D g2=(Graphics2D) g;

//         Font font =new Font("黑体",Font.PLAIN, 16);
//         g2.setFont(font);
//         g2.drawString("九九乘法口诀表",DEFAULT_WIDTH/2-60,30);
        
//         font=new Font("Times New Roman",Font.PLAIN,12);
//         g2.setFont(font);
//         g2.drawString("1 2 3 4 5 6 7 8 9", DEFAULT_WIDTH/2-100,60);
//         g2.drawString("==================", DEFAULT_WIDTH/2-130, 76);
//         for(int i=1;i<100;i++)
//         {
//             g2.drawString(new Integer(i).toString(),DEFAULT_WIDTH/2-126,76+i*18);
//             for(int j=1;j<10;j++)
//             {
//                 g2.drawString(new Integer(i*j).toString(),DEFAULT_WIDTH/2-122+J*24,76+i*18);
//             }
//         }
//     }

// }