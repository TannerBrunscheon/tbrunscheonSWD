
/**
 * Created by Tanner on 8/31/2016.
 */
import javax.lang.model.util.ElementScanner6;
import java.util.Random;
import java.util.Scanner;

public class Message {
    Scanner input = new Scanner(System.in);
    private String messageStr;
    private char[] messageChar;
    private Random rando = new Random();
    private int key;
    private int tempKey;

    public Message() {
        System.out.printf("Please Enter Your Message: %n%n");
        messageStr = input.nextLine();
        messageStr = messageStr.toUpperCase();
    }

    public void encryptMessage(){
        messageChar = messageStr.toCharArray();
        key = rando.nextInt(36);
        for (int i = 0; i<messageStr.length(); i++)
        {
            for (int j = 0; j<36; j++){
                if(messageChar[i]==OTPMenu.alphabet[j])
                {
                    if(j+key>36){
                        tempKey = (j+key)%36;
                        messageChar[i] = OTPMenu.alphabet[tempKey];
                        j=36;
                    }
                    else{
                        messageChar[i] = OTPMenu.alphabet[j+key];
                        j=36;
                    }
                }
            }
        }
    }

    public int getKey() {
        return key;
    }

    public String getUnencryptedMessage() {
        return messageStr;
    }

    public String getEncrypedMessage() {
        // Got from https://stackoverflow.com/questions/7655127/how-to-convert-a-char-array-back-to-a-string
        String encrypted = new String(messageChar);
        return encrypted;
    }
}
