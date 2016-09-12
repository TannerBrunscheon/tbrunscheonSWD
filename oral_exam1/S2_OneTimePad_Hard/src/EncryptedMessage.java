import java.util.Random;
import java.util.Scanner;

/**
 * Created by tbrunscheon on 9/9/16.
 */
public class EncryptedMessage {
    private static final char  ALPHABET [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private String messageStr;
    private char[] encryptedChar;
    private Random rando = new Random();
    private int[] key;
    private String outKey
    private int tempKey;



    public EncryptedMessage() {
        System.out.printf("Please put in a message! %n");
    }

    public EncryptedMessage(String messageStr) {
        this.messageStr = messageStr;
    }

    private void encryptMessage() {
        encryptedChar = new char[messageStr.length()];

        key = new int[messageStr.length()];

        for (int i = 0; i<messageStr.length(); i++) {
            if (messageStr.charAt(i) != ' '){
                key[i] = rando.nextInt(35);
                for (int j = 0; j < 36; j++) {
                    if (messageStr.charAt(i) == ALPHABET[j]) {
                        if ((j + key[i]) > 35) {
                            tempKey = (j + key[i]) % 36;
                            encryptedChar[i] = ALPHABET[tempKey];
                            j = 36;
                        }
                        else if (messageStr.charAt(i) == ' '){

                            j = 36;
                        }
                        else
                        {
                            encryptedChar[i] = ALPHABET[j + key[i]];
                            j = 36;
                        }
                    }
                }
            }
        }
    }

    public String getEncrypted() {
        this.encryptMessage();
        String encrypted = new String(encryptedChar);
        return encrypted;
    }

    public String getKey() {
        key =
        return key.toString();
    }
}
