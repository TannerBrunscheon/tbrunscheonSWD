
import java.util.Random;

/**
 * This class is the main Encryption class for this library. Its constructor takes in 1 argument into the class which is the message.
 * It has one primary method encrypt Message and various getters. The encryption is done in the constructor so the
 * @author Tanner Brunscheon
 */
public class EncryptedMessage {
    /**
     * This is the string of characters used in the encryption and decryption software. All words must only have
     * characters in this array or spaces. This is the "Index"
     */
    private final char  ALPHABET [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    /**
     * Message to be encrypted.
     */
    private String messageStr;
    /**
     * Holds encrypted message.
     */
    private char[] encryptedChar;
    /**
     * Random number generator.
     */
    private Random rando = new Random();
    /**
     * Array of ints representing the key.
     */
    private int[] key;


    /**
     * This constructor takes in message string and encrypts the message. The message is made uppercase because thats
     * how the characters are indexed
     * @param messageStr Message to be encrypted
     */
    public EncryptedMessage(String messageStr) {
        this.messageStr = messageStr.toUpperCase();
        this.encryptMessage();
    }

    /**
     * This is the primary class of the DecryptedMessage. This class generates a number that goes 0-35 and puts a character
     * of the index of the character in the message + the randomly generated number into the encrypted message string and adds
     * the randomly generated number into the key. If it sees the next character as a space it adds a 0 to the array.
     */
    private void encryptMessage() {
        //Create new message array for the encryption process
        encryptedChar = new char[messageStr.length()];
        // Create new key array for encryption process
        key = new int[messageStr.length()];
        //Loop through the in message
        for (int i = 0; i<messageStr.length(); i++) {
            //Check for an empty char
            if (messageStr.charAt(i) != ' '){
                //Loop through the character array plus 1. Checks for matches.
                for (int j = 0; j <= 36; j++) {
                    //Throw an error if no matches
                    if (j==36){
                        throw new IllegalArgumentException("Character Not In Array!(A-Z,0-9 only!)");
                    }
                    //Makes sure character is in array Grab index
                    if (messageStr.charAt(i) == ALPHABET[j]) {
                        // Genarate random number 1-35 so there are no double loops
                        key[i] = rando.nextInt(34)+1;
                        //Check if there needs to be a loop. If so add the key and the index together and remainder 36. If not just add them together.
                        if ((j + key[i]) > 35){
                            encryptedChar[i] = ALPHABET[(j + key[i])%36];
                            j = 37;
                        }
                        else{
                            encryptedChar[i] = ALPHABET[j + key[i]];
                            j = 37;
                        }
                    }
                }
            }
            else {
                //Add a space in the char array.
                encryptedChar[i] = ' ';//
            }
        }
    }

    /**
     * Return method of the encrypted message. As an array of characters.
     * @return The encrypted message as an array of characters. Basic form.
     */

    public char[] getEncrypted() {
        return encryptedChar;
    }

    /**
     * Return method of the encrypted message. As a string.
     * @return The encrypted message as string.
     */

    public String getStrEncrypted() {
        return encryptedChar.toString();
    }

    /**
     * Return method of the key.
     * @return The key used for decryption.
     *
     */
    public int[] getKey() {
        return key;
    }

}
