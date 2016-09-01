
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
    private Random rando = new Random();
    private int[] key;
    private int tempKey;
    private String strKey;

    public Message() {
        System.out.printf("Please Enter Your Message: %n%n");
        messageStr = input.nextLine();
        messageStr = messageStr.toUpperCase();
        key = new int[messageStr.length()];
    }
    public void encryptMessage(){
        messageChar = messageStr.toCharArray();
        encryptedChar = messageChar;

        for (int i = 0; i<messageStr.length(); i++) {
            key[i] = rando.nextInt(36);
            for (int j = 0; j<36; j++){
                if(messageChar[i]==OTPMenu.alphabet[j]) {
                    if(j+key[i]>35){
                        tempKey = (j+key[i])%35;
                        encryptedChar[i] = OTPMenu.alphabet[tempKey];
                        j=36;
                    }
                    else{
                        encryptedChar[i] = OTPMenu.alphabet[j+key[i]];
                        j=36;
                    }
                }
            }
        }
    }
    public void decryptMessage(){
        for (int i = 0; i<messageStr.length(); i++) {
            for (int j = 0; j<36; j++){
                if(encryptedChar[i]==OTPMenu.alphabet[j]) {
                    if(j-key[i]<0){
                       tempKey = (j-key[i])%35*-1;
                       encryptedChar[i] = OTPMenu.alphabet[tempKey];
                       j=36;
                    }
                    else{
                       encryptedChar[i] = OTPMenu.alphabet[j-key[i]];
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
            // Got from https://stackoverflow.com/questions/7655127/how-to-convert-a-char-array-back-to-a-string
            String encrypted = new String(encryptedChar);
            return encrypted;
    }
    public String getDecryptedMessage(){
        String decrypted = new String(encryptedChar);
        return decrypted;
    }

}
