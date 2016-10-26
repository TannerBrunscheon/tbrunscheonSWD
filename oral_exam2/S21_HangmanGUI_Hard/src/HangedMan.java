import javax.swing.*;
import java.awt.*;

/**
 * Created by Tanner on 10/24/2016.
 */
public class HangedMan extends JPanel {
    private int count = 0;

    @Override
    protected void paintComponent(Graphics g){
       super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(Color.black);
        g.drawLine(185,50,185,10);
        g.drawLine(185,10,125,10);
        g.drawLine(125,10,125,250);
        g.drawLine(100,250,150,250);
        switch (count){
            case 6:
                g.drawLine(185,170,160,195);
            case 5:
                g.drawLine(185,170,210,195);
            case 4:
                g.drawLine(185,125,160,150);
            case 3:
                g.drawLine(185,125,210,150);
            case 2:
                g.drawLine(185,100,185,170);
            case 1:
                g.drawOval(160,50,50,50);
                break;
        }
   }
   protected void resetCount(){
       count = 0;
       repaint();
   }
   protected void addPart(){
       count++;
       repaint();
   }
}
