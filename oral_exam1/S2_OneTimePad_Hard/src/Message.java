
/**
 * Created by Tanner on 8/31/2016.
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Message {
    Scanner input = new Scanner(System.in);
    private String messageStr;
    private char[] messageChar;
    private char[] encryptedChar;
    private char[] decryptedChar;
    private Random rando = new Random();
    private int[] key;
    private int tempKey;
    private String strKey;
    final char  ALPHABET [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};


    public Message() {
        System.out.printf("Please Enter Your Message: ");
        messageStr = input.nextLine();
        messageStr = messageStr.toUpperCase();
        key = new int[messageStr.length()];
    }

    public void encryptMessage(){
        messageChar = messageStr.toCharArray();
        encryptedChar = messageChar;

        for (int i = 0; i<messageStr.length(); i++) {
            key[i] = rando.nextInt(35);
            for (int j = 0; j<36; j++){
                if(messageChar[i]==ALPHABET[j]) {
                    if((j+key[i])>35){
                        tempKey = (j+key[i])%36;
                        encryptedChar[i] = ALPHABET[tempKey];
                        j=36;
                    }
                    else{
                        encryptedChar[i] = ALPHABET[j+key[i]];
                        j=36;
                    }
                }
            }
        }
    }
    public void decryptMessage(){
        decryptedChar = encryptedChar;
        for (int i = 0; i<messageStr.length(); i++) {
            for (int j = 0; j<36; j++){
                if(encryptedChar[i]== ALPHABET[j]) {
                    if((j-key[i])<0){
                       tempKey = ((j-key[i])+36);
                       decryptedChar[i] = ALPHABET[tempKey];
                       j=36;
                    }
                    else{
                       decryptedChar[i] = ALPHABET[j-key[i]];
                       j=36;
                   }
               }
           }
       }
    }

    public String getUnencryptedMessage() {
        return messageStr;
    }
    public String getKey(){
         strKey = Arrays.toString(key);
        return strKey;
    }
    public String getEncryptedMessage() {

        try{
            String encrypted = new String(encryptedChar);
            return encrypted;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("STRING IS EMPTY");
        }
    }
    public String getDecryptedMessage(){
        try{
            String decrypted = new String(decryptedChar);

            return decrypted;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("STRING NOT DECRYPTED");
        }

    }

}
