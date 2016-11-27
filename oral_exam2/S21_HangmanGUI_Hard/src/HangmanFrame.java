import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created by Tanner on 10/22/2016.
 */
public class HangmanFrame extends JFrame{
    /**
     * The man himself
     */
    private final HangedMan hangedMan = new HangedMan();
    /**
     * The message guessed so far.
     */
    private final JTextField messageBox = new JTextField();
    /**
     * The input from te user
     */
    private final JTextField input = new JTextField();
    /**
     * Box to display wrong guesses
     */
    private final JTextField wrong = new JTextField();
    /**
     * Layout that the gui is based on
     */
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    /**
     * Constraints for the layout to set things up for the layout
     */
    private final GridBagConstraints constraints = new GridBagConstraints();
    /**
     * Label for guesses
     */
    private final JLabel wrongLabel = new JLabel("Wrong Guesses");
    /**
     * Label for user input
     */
    private final JLabel guessLabel = new JLabel("Please enter your guess:");
    /**
     * Label for word known
     */
    private final JLabel wordKnown = new JLabel("Word known up until now.");
    /**
     * Message inputed
     */
    private String message;
    /**
     * Guess so far
     */
    private String guessStr;
    /**
     * Wrong guesses array
     */
    private char[] wrongChar = new char[6];
    /**
     * Message and guessed so far character string
     */
    private char[] messageChar,guessChar;
    /**
     * Amount of guesses 6 max
     */
    private int guessesCount =0;
    /**
     * Is the user correct?
     */
    private boolean correct = false;

    /**
     * Gets the word from the user and builds the gui for the screen.
     */
    public HangmanFrame() {
        super("Hangman Game");
        setLayout(gridBagLayout);//Layout
        //Get user word for the game
        message = JOptionPane.showInputDialog("Enter your game word!");
        messageChar = message.toUpperCase().toCharArray();
        //Make a guess array that is the length of the message and fill it with undercores
        guessChar = new char[messageChar.length];
        for(int i =0;i<messageChar.length;i++){
            if(messageChar[i]==' ')
            {
                guessChar[i] = ' ';
            }
            else {
                guessChar[i] = '_';
            }
        }
        guessStr = "";
        //Make the guess string with the characters in the guess character array
        for (int j =0;j<guessChar.length;j++)
        {
            guessStr = guessStr+guessChar[j]+' ';
        }
        //Fill the message box with guessed so fat
        messageBox.setText(guessStr);
        messageBox.setEditable(false);
        //Set the wrong box with the array of wrong guesses
        wrong.setText(Arrays.toString(wrongChar));
        wrong.setEditable(false);
        //Listen for enter for input
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Check if character entered at the first positiong is in the message
                char inString= input.getText().toUpperCase().charAt(0);
                boolean inMessage = false;
                for (int i =0;i < messageChar.length;i++){
                    //If the character is in the string add it to the guess string at all the spots its in the message
                    if (inString == messageChar[i]){
                        guessChar[i] = inString;
                        guessStr = "";
                        for (int j =0;j<guessChar.length;j++)
                        {
                            guessStr = guessStr+guessChar[j]+' ';
                        }
                        messageBox.setText(guessStr);
                        inMessage = true;
                    }
                }
                //If not add a part to the man and add the character to the wrong array
                if (inMessage == false){
                    wrongChar[guessesCount] = inString;
                    guessesCount++;
                    hangedMan.addPart();
                    wrong.setText(Arrays.toString(wrongChar));
                }
                correct = false;
                //Check if guess char is full of characters meaning word is complete and if it is display to the user
                for(int i =0;i<messageChar.length;i++){
                    if (guessChar[i] == '_'){
                        correct = true;
                    }
                }
                if(correct == false){
                    JOptionPane.showMessageDialog(null,"Correct! Guesses win!");
                    return;
                }
                //If user is out of guesses desplay that they lost
                if(guessesCount == 6){
                    JOptionPane.showMessageDialog(null,"Guessers lose!");
                    messageBox.setText(Arrays.toString(messageChar));
                    input.setEditable(false);
                    return;
                }
            }
        });


        constraints.fill = GridBagConstraints.BOTH; //Set up constraints
        //Add everything in its proper spots
        add(hangedMan,0,0,1,2);
        add(guessLabel,0,2,1,1);
        add(input,1,2,1,1);
        add(wordKnown,0,3,1,1);
        add(messageBox,1,3,1,1);
        add(wrongLabel,0,1,1,1);
        add(wrong,1,1,1,1);

    }
    /**
     * Using polymorphism, this method takes in any component to add to the frame and adds it to the
     * layout at the row column specified with the width and height specified.
     * @param component Component to be added to the frame
     * @param row Row the component to be added at
     * @param column Column the component to be added at
     * @param width Width the of the component
     * @param height Height of the component
     */
    private void add(Component component, int row, int column, int width, int height){
        //Set the value of the x and y coords for where the component should be
        constraints.gridx=column;
        constraints.gridy=row;
        //Set the value of the width and height for where the component should be
        constraints.gridwidth=width;
        constraints.gridheight=height;
        //Allows things to expand
        constraints.weightx=.5;
        constraints.weighty=.5;
        //Sets the components constraints on the layout
        gridBagLayout.setConstraints(component,constraints);
        // Add the component
        add(component);
    }
}
