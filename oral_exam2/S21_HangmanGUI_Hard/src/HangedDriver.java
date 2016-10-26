import javax.swing.*;

/**
 * Created by Tanner on 10/25/2016.
 */
public class HangedDriver {


    public static void main(String[] args) {
        HangmanFrame hangmanFrame = new HangmanFrame();
        hangmanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hangmanFrame.setSize(3000,400);
        hangmanFrame.setVisible(true);
    }

}
