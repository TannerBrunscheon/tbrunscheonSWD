import javax.swing.*;
import java.awt.*;


/**
 * Created by Tanner on 9/25/2016.
 */
public class RectanglePanel extends JPanel {
    private Color color = new Color(0,0,0);
    private int width = 200;
    private int height = 200;

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(color);
        g.fillRect(0,0,width,height);
    }

    public void setColor(int red,int green,int blue)
    {
        color = new Color(red,green,blue);
        repaint();
    }
}
