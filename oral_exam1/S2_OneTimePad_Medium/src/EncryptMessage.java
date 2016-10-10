
import java.util.Scanner;
/**
 * This class is the driver to the EncryptedMessage class. It takes in user input for the encrypted message and calls the correct
 * methods in EncryptedMessage. It then outputs the results to the screen.
 * @author Tanner Brunscheon
 */
public class EncryptMessage {

    public static void main(String[] args) {
        //String for input
        String messageStr;
        //New input
        Scanner input = new Scanner(System.in);
        //Char array for encrypted output
        char[] encrypted;
        //Int array for encrypted output
        int[] key;


        //Read in message and make it uppercase
        System.out.printf("Please Enter Your Message: ");
        messageStr = input.nextLine();
        messageStr = messageStr.toUpperCase();
        //Create new encrypted message and feed in message
        EncryptedMessage message = new EncryptedMessage(messageStr);

        //Get the encryped message and the key
        encrypted = message.getEncrypted();
        key = message.getKey();

        //Print out encrypted
        for (int i=0; i<encrypted.length;i++) {
                System.out.print(encrypted[i]);
        }
        System.out.printf("%n");

        // Print out key
        for (int i=0; i<key.length;i++) {
            System.out.printf(key[i]+ " ");
        }

    }

}
