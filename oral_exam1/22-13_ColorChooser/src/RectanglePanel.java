import javax.swing.*;
import java.awt.*;


/**
 * Created by Tanner on 9/25/2016.
 */
public class RectanglePanel extends JPanel {
    private Color color = new Color(0,0,0);

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(color);
        super.paintComponent(g);
        g.fillRect(0,0,20000,100);
    }

    public void setColor(int red,int green,int blue)
    {
        color = new Color(red,green,blue);
        repaint();
    }

}
