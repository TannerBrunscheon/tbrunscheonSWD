import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tanner on 9/26/2016.
 */
public class ConverterFrame extends JFrame {
    public ConverterFrame() {

        super("Roman Converter");
        setLayout(new GridLayout(2, 1));

        final JTextField arabicSide = new JTextField();
        arabicSide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent enter) {
                String userInput = arabicSide.getText();
                try {
                    int num = Integer.parseInt(userInput);
                    ArabicConverter arabicConverter = new ArabicConverter(num);
                    String outString = arabicConverter.toString();
                    JOptionPane.showMessageDialog(null, outString);
                } catch (NumberFormatException f) {
                    RomanConverter romanConverter = new RomanConverter(userInput);
                    String outString = romanConverter.toString();
                    JOptionPane.showMessageDialog(null, outString);
                }
            }
        });
        add(new JLabel("Enter Number (Roman or Arabic): "));
        add(arabicSide);

    }
}
