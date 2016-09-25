import javax.swing.*;
import java.awt.*;


/**
 * Created by Tanner on 9/25/2016.
 */
public class RectanglePanel extends JPanel {
    private int side = 10;
    private Color color = new Color(0,0,0);

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(color);
        super.paintComponent(g);
        g.fillRect(10,10,side,side);
    }

    public void setColor(int red,int green,int blue)
    {
        color = new Color(red,green,blue);
        repaint();
    }

}
