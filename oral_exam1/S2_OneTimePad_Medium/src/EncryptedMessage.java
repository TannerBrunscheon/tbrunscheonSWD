
import java.util.Random;

/**
 * This class is the main Encryption class for this library. Its constructor takes in 1 argument into the class which is the message.
 * It has one primary method encrypt Message and various getters. The encryption is done in the constructor so the
 * @author Tanner Brunscheon
 */
public class EncryptedMessage {
    /**
     * This is the string of characters used in the encryption and decryption software. All words must only have
     * characters in this array or spaces.
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
     * Temperary key used in the encryption process.
     */
    private int tempKey;


    /**
     * This constructor takes in message string and encrypts the message.
     * @param messageStr Message to be encrypted
     */
    public EncryptedMessage(String messageStr) {
        this.messageStr = messageStr;
        this.encryptMessage();
    }

    /**
     * This is the primary class of the DecryptedMessage. This class generates a number that goes 0-35 and puts a character
     * of the index of the character in the message + the randomly generated number into the encrypted message string and adds
     * the randomly generated number into the key. If it sees the next character as a space it adds a 0 to the array.
     */
    private void encryptMessage() {
        encryptedChar = new char[messageStr.length()];
        key = new int[messageStr.length()];
        for (int i = 0; i<messageStr.length(); i++) {
            if (messageStr.charAt(i) != ' '){
                for (int j = 0; j < 36; j++) {
                    if (messageStr.charAt(i) == ALPHABET[j]) {
                        key[i] = rando.nextInt(34)%35 +1;
                        if ((j + key[i]) > 35){
                            tempKey = (j + key[i])%36;
                            encryptedChar[i] = ALPHABET[tempKey];
                            j = 36;
                        }
                        else{
                            encryptedChar[i] = ALPHABET[j + key[i]];
                            j = 36;
                        }
                    }
                }
            }
            else {
                encryptedChar[i] = ' ';
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
     */
    public int[] getKey() {
        return key;
    }

}
