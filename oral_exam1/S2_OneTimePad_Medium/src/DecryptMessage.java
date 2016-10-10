
import java.util.Scanner;

/**
 * This class is the driver to the DecryptedMessage class. It takes in user input for the encrypted message and key,does
 * its own error checking in addition to the DecryptedMessage class's own error checking and calls the correct methods in
 * the DecryptedMessage class as an example.
 * @author Tanner Brunscheon
 */
public class DecryptMessage {
    public static void main(String[] args) {

        /**
         * Message to be decrypted.
         */
        String messageStr;
        /**
         * Input scanner for user input
         */
        Scanner input = new Scanner(System.in);
        /**
         * Key as a string before conversion to array of ints. Which is required by DecryptedMessage.
         */
        String keyTemp;
        /**
         * Key as an array of strings after splitting.
         */
        String[] keyArray;
        /**
         * Key as an array of ints after conversion
         */
        int[] key;

        // Get inputs from user
        System.out.printf("Please Enter Your Encrypted Message: ");
        messageStr = input.nextLine();
        System.out.printf("Please Enter Your Key: ");
        keyTemp = input.nextLine();

        // Split the key into an array of strings. On the spaces
        keyArray = keyTemp.split(" ");

        key= new int[keyArray.length];
        //First it checks if the key is to short and if its is a number by trying to convert it
        try {
            //Checks if key is too long
            if (keyArray.length>messageStr.length()){
                throw new IllegalArgumentException("Key too long");
            }
            else {
                //Switches everything to integers
                for (int i = 0; i < keyArray.length; i++) {
                    key[i] = Integer.parseInt(keyArray[i]);
                }
            }
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("Key not string of numbers");
        }
        catch (ArrayIndexOutOfBoundsException e ){
            throw new IllegalArgumentException("Key too short");
        }
        // Creates a new decrypt message class with key and message
        DecryptedMessage message = new DecryptedMessage(messageStr.toUpperCase(),key);
        System.out.println(message);

    }
}
