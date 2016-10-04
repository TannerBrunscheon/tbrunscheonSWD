import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Converter frame extends JFrame. All work is done in the constructor.
 */
public class ConverterFrame extends JFrame {
    /**
     * Text field for user input
     */
    private final JTextField text = new JTextField();

    /**
     * This constructor sets the title sets the layout and adds an action listener to the text field. It then checks if what was entered was an int or a string and
     * calls the appropriate ArabicConversion and RomanConversion which ever appropriate.
     */
    public ConverterFrame() {
        super("Roman Converter");
        setLayout(new GridLayout(2, 1));

        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = text.getText();
                try {
                    int num = Integer.parseInt(userInput);
                    String outString = RomanToArabicConverter.ArabicConversion(num);
                    JOptionPane.showMessageDialog(text, outString);
                } catch (NumberFormatException f) {
                    try{
                        int out = RomanToArabicConverter.RomanConversion(userInput);
                        JOptionPane.showMessageDialog(text, out);
                    } catch (IllegalArgumentException g){
                        JOptionPane.showMessageDialog(text, "Invalid Numerals");
                    }

                }
            }
        });
        add(new JLabel("Enter Number (Roman or Arabic): "));
        add(text);

    }
}
