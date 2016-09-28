import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tanner on 9/26/2016.
 */
public class ConverterFrame extends JFrame {
    private final JTextField text = new JTextField();
    private final TextHandler textHandler = new TextHandler();

    public ConverterFrame() {

        super("Roman Converter");
        setLayout(new GridLayout(2, 1));

        text.addActionListener(textHandler);
        add(new JLabel("Enter Number (Roman or Arabic): "));
        add(text);

    }

    private class TextHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = text.getText();
            try {
                int num = Integer.parseInt(userInput);
                ArabicConverter arabicConverter = new ArabicConverter(num);
                String outString = arabicConverter.toString();
                JOptionPane.showMessageDialog(text, outString);
            } catch (NumberFormatException f) {
                RomanConverter romanConverter = new RomanConverter(userInput);
                String outString = romanConverter.toString();
                JOptionPane.showMessageDialog(text, outString);
            }
        }
    }
}
