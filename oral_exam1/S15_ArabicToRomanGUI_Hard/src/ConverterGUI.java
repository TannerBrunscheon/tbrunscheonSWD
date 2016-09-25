
/**
 * Created by Tanner on 9/20/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterGUI{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Roman Converter");
        frame.setLayout(new GridLayout(2,2));
        final JTextField arabicSide = new JTextField();
        arabicSide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = arabicSide.getText();
                try {
                    int num = Integer.parseInt(userInput);
                    ArabicConverter arabicConverter = new ArabicConverter(num);
                    String outString = arabicConverter.toString();
                    JOptionPane.showMessageDialog(frame , outString);
                } catch (NumberFormatException f) {
                    RomanConverter romanConverter = new RomanConverter(userInput);
                    String outString = romanConverter.toString();
                    JOptionPane.showMessageDialog(frame , outString);
                }
            }
        });
        frame.add(new JLabel("Enter Number (Roman or Arabic): "));
        frame.add(arabicSide);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
