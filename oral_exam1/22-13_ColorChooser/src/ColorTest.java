import javax.swing.*;

/**
 * This is the driver for the MyColorChooser class. All it does is create a MyColorChooser object and set
 * its close operation, make it small as possible and set it visible.
 */
public class ColorTest {
    public static void main(String[] args) {
        MyColorChooser myColorChooser = new MyColorChooser();
        myColorChooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myColorChooser.pack();
        myColorChooser.setVisible(true);
    }
}

