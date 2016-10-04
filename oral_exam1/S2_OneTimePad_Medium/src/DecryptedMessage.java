
/**
 * This class is the main decryption class for this library. Its constructor takes in 2 arguments into the class.
 * It has two methods decryptMessage and toString. The toString method is the only publicly available method
 * and it does the decryption and returns the decrypted message as a string.
 * @author Tanner Brunscheon
 */
public class DecryptedMessage {
    /**
     * This is the string of characters used in the encryption and decryption software. All words must only have
     * characters in this array or spaces. This is the "Index".
     */
    private final char  ALPHABET [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    /**
     * The message as a string to be decrypted.
     */
    private String messageStr;
    /**
     * The key that decrypts the message.
     */
    private int[] key;
    /**
     * The decrypted array of characters.
     */
    private char[] decryptedChar;

    /**
     * This constructor takes in message string and an array of ints as the decryption key. It also error checks the
     * key to make sure the key matches the length of the message.
     * @param messageStr Message to decrypt
     * @param key Decryption key
     */
    public DecryptedMessage(String messageStr, int[] key) {
        this.messageStr = messageStr;
        this.key = key;
        if (key.length<messageStr.toCharArray().length){
            throw new IllegalArgumentException("Key too short");
        }
        else if (key.length>messageStr.toCharArray().length){
            throw new IllegalArgumentException("Key too long");
        }
    }

    /**
     * This is the primary class of the DecryptedMessage. This class uses the variables stored in the object and the
     * key to decrypt the message. It does so by taking the index number of the letter in the encrypted message and
     * adds the key to it. If this results in looping because the index number ends up below 0, it adds 36 to simulate
     * the looping. 36 being the size of the index. It also ignores decryption if it sees the next character being a space.
     */
    private void decryptMessage(){
        decryptedChar = new char[messageStr.length()];
        for (int i = 0; i<messageStr.length(); i++) {
            for (int j = 0; j<36; j++){
                if (messageStr.charAt(i) == ' '){
                    j = 36;
                    decryptedChar[i] = ' ';
                }
                else {
                    if (messageStr.charAt(i) == ALPHABET[j]) {
                        if ((j - key[i]) < 0) {
                            decryptedChar[i] = ALPHABET[((j - (key[i])) + 36)];
                            j = 36;
                        } else {
                            decryptedChar[i] = ALPHABET[j - key[i]];
                            j = 36;
                        }
                    }
                }
            }
        }
    }

    /**
     * ToString is the return method in the DecryptedMessage class. It calls decrypt message and formats the decrypted
     * output into a string.
     * @return The decrypted message as a string.
     */
    @Override
    public String toString() {
        decryptMessage();
        String decrypted = new String(decryptedChar);
        return decrypted;
    }
}