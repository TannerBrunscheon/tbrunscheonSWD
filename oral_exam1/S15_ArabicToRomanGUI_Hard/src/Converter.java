import javax.swing.*;

/**
 * The main driver for the converter frrame GUI. All it does is create a new converter frame, set its close, set its
 * size and set it visible.
 */
public class Converter {
    public static void main(String[] args) {
        ConverterFrame converterFrame = new ConverterFrame();
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converterFrame.setSize(300, 100);
        converterFrame.setVisible(true);
    }
}
