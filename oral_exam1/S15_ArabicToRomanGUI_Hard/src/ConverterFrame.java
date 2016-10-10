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
        //Set header of frame
        super("Roman Converter");
        //Set layout
        setLayout(new GridLayout(2, 2));

        //Add key adapter tp the arabic text field. When the key is release it needs to update the other text box
        arabic.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //Get text
                String userInput = arabic.getText();
                //If one is empty set them both to 0
                if (userInput.isEmpty()){
                    roman.setText("0");
                    arabic.setText("0");
                    return;
                }
                // Try converting string. If it fails error out.
                try {
                    //String to int
                    int num = Integer.parseInt(userInput);

                    if (num < 0 || num > 3999)
                    {
                        //Prompt user of outside of bounds
                        JOptionPane.showMessageDialog(arabic, "Number not supported. 0-3999 supported");
                        //Delete next text
                        //found at https://stackoverflow.com/questions/17634401/jtextfield-removing-end-characters
                        arabic.setText(arabic.getText().substring(0, arabic.getText ().length() - 1));
                    }
                    else {
                        String outString = RomanToArabicConverter.ArabicConversion(num);
                        roman.setText(outString);
                    }
                } catch (NumberFormatException f) {

                    JOptionPane.showMessageDialog(arabic, "Number not supported. 0-3999 supported");
                    //Delete next text
                    //found at https://stackoverflow.com/questions/17634401/jtextfield-removing-end-characters
                    arabic.setText(arabic.getText().substring(0, arabic.getText ().length() - 1));

                }
            }
        });
        roman.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //Get user numeral
                String userInput = roman.getText();
                //If one is empty set them both to 0
                if (userInput.isEmpty()){
                    roman.setText("0");
                    arabic.setText("0");
                    return;
                }

                //Check if its an integer
                try {
                    int out = RomanToArabicConverter.RomanConversion(userInput);
                    arabic.setText(Integer.toString(out));
                }catch (IllegalArgumentException g){
                    JOptionPane.showMessageDialog(roman, "Please enter a valid roman numeral");
                    //Delete next text
                    //found at https://stackoverflow.com/questions/17634401/jtextfield-removing-end-characters
                    roman.setText(roman.getText().substring(0, roman.getText ().length() - 1));
                }
            }
        });
        //Add componenets
        add(new JLabel("Enter Number (Arabic): "));
        add(new JLabel("Enter Numeral (Roman): "));
        add(arabic);
        add(roman);

    }
}
