import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by Tanner on 9/25/2016.
 */
public class MyColorChooser extends JFrame{
    private final JTextField rTextField = new JTextField();
    private final JTextField gTextField = new JTextField();
    private final JTextField bTextField = new JTextField();
    private final RectanglePanel myPanel;
    private final JSlider rSlider;
    private final JSlider gSlider;
    private final JSlider bSlider;
    private int red=0;
    private int green=0;
    private int blue=0;


    public MyColorChooser() {
        super("Color Chooser");
        myPanel = new RectanglePanel();


        rSlider = new JSlider(SwingConstants.HORIZONTAL,0,256,0);
        rSlider.setMajorTickSpacing(8);
        rSlider.setPaintTicks(true);

        gSlider = new JSlider(SwingConstants.HORIZONTAL,0,256,0);
        gSlider.setMajorTickSpacing(8);
        gSlider.setPaintTicks(true);

        bSlider = new JSlider(SwingConstants.HORIZONTAL,0,256,0);
        bSlider.setMajorTickSpacing(8);
        bSlider.setPaintTicks(true);

        rSlider.addChangeListener(
                new ChangeListener()
                {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        red = rSlider.getValue();
                        myPanel.setColor(red,green,blue);
                    }
                }
        );
        gSlider.addChangeListener(
                new ChangeListener()
                {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        green = gSlider.getValue();
                        myPanel.setColor(red,green,blue);
                    }
                }
        );
        bSlider.addChangeListener(
                new ChangeListener()
                {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        blue = bSlider.getValue();
                        myPanel.setColor(red,green,blue);
                    }
                }
        );
        add(rSlider,BorderLayout.NORTH);
        add(gSlider,BorderLayout.NORTH);
        add(bSlider,BorderLayout.NORTH);
        add(myPanel,BorderLayout.CENTER);
    }
}
