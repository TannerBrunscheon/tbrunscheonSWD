import javax.swing.*;

/**
 * Created by Tanner on 9/25/2016.
 */
public class ColorGUI {
    public static void main(String[] args) {
        MyColorChooser myColorChooser = new MyColorChooser();
        myColorChooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myColorChooser.setSize(300,300);
        myColorChooser.setVisible(true);

    }
}
