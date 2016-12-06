import javax.swing.*;
import java.awt.*;

/**
 * Panel that paints the hanged man to the screen based on how many times the addPart method has been called.
 */
public class HangedMan extends JPanel {
    /**
     * Running count of how many body parts have been added to the man.
     */
    private int count = 0;

    /**
     * Edited paint component method that draws the man based on the part count and his hanging tree.
     * @param g Graphics created by the system
     */
    @Override
    protected void paintComponent(Graphics g){
       super.paintComponent(g);
        //Background
        setBackground(Color.white);
        g.setColor(Color.black);
        //Gallows
        g.drawLine(185,50,185,10);
        g.drawLine(185,10,125,10);
        g.drawLine(125,10,125,250);
        g.drawLine(100,250,150,250);
        switch (count){
            case 6://Leg
                g.drawLine(185,170,160,195);
            case 5://Leg
                g.drawLine(185,170,210,195);
            case 4://Arm
                g.drawLine(185,125,160,150);
            case 3://Arm
                g.drawLine(185,125,210,150);
            case 2://Body
                g.drawLine(185,100,185,170);
            case 1://Head
                g.drawOval(160,50,50,50);
                break;
        }
   }

    /**
     * Adds a number to the count counter and repaints the figure.
     */
   protected void addPart(){
       count++;//Add to count overall
       repaint();
   }
}
