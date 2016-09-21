import java.util.Arrays;

/**
 * Created by Tanner on 9/11/2016.
 */
public class DecryptedMessage {
    private static final char  ALPHABET [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private String messageStr;
    private int[] key;
    private int tempKey;
    private char[] decryptedChar;

    public DecryptedMessage(String messageStr, int[] key) {
        this.messageStr = messageStr;
        this.key = key;
    }

    private void decryptMessage(){// TODO Error check both the key and the message probably do try catch
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
                            tempKey = ((j - key[i]) + 36);
                            decryptedChar[i] = ALPHABET[tempKey];
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

    @Override
    public String toString() {
        decryptMessage();
        String decrypted = new String(decryptedChar);
        return decrypted;
    }
}