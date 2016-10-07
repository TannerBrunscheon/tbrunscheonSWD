import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

/**
 * Converter frame extends JFrame. All work is done in the constructor.
 */
public class ConverterFrame extends JFrame {
    /**
     * Text field for user input
     */
    private final JTextField arabic = new JTextField();
    private final JTextField roman = new JTextField();

    /**
     * This constructor sets the title sets the layout and adds an action listener to the text field. The user then
     * enters an input.It then checks if what was entered was an int or a string and calls the appropriate ArabicConversion and RomanConversion which ever appropriate.
     */
    public ConverterFrame() {
        super("Roman Converter");
        setLayout(new GridLayout(2, 2));

        arabic.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String userInput = arabic.getText();//
                try {
                    int num = Integer.parseInt(userInput);
                    if (num < 0 || num > 3999)
                    {
                        JOptionPane.showMessageDialog(arabic, "Number not supported. 0-3999 supported");
                    }
                    else {
                        String outString = RomanToArabicConverter.ArabicConversion(num);
                        roman.setText(outString);
                    }
                } catch (NumberFormatException f) {

                    JOptionPane.showMessageDialog(arabic, "Number not supported. 0-3999 supported");

                }
            }
        });
        roman.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String userInput = roman.getText();//
                try {
                    int num = Integer.parseInt(userInput);
                    JOptionPane.showMessageDialog(roman, "Please enter a roman numeral");
                } catch (NumberFormatException f) {
                    int out = RomanToArabicConverter.RomanConversion(userInput);
                    arabic.setText(Integer.toString(out));

                }
            }
        });

        add(new JLabel("Enter Number (Arabic): "));
        add(new JLabel("Enter Numeral (Roman): "));
        add(arabic);
        add(roman);

    }
}
