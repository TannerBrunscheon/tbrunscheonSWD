import javax.swing.*;
import java.awt.*;


/**
 * Created by Tanner on 9/25/2016.
 */
public class RectanglePanel extends JPanel {
    /**
     * Stored RGB value used to color the rectangle
     */
    private Color color = new Color(0,0,0);

    /**
     * Overwrites paint component adding setBackground to color the component.Is only called during repaint.
     * @param g Graphics created by this class.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(color);
    }

    /**
     * Changes the color in this object and repaints the panel.
     * @param red Red part of the RGB in color.
     * @param green Green part of the RGB in color.
     * @param blue Blue part of in RGB in color.
     */
    public void setColor(int red,int green,int blue)
    {
        color = new Color(red,green,blue);
        repaint();
    }
}
