
import java.util.Scanner;
/**
 * Created by Tanner on 8/31/2016.
 */
public class EncryptMessage {

    public static void main(String[] args) {
        String messageStr;
        Scanner input = new Scanner(System.in);
        String encrypted;
        int[] key;


        System.out.printf("Please Enter Your Message: ");
        messageStr = input.nextLine();
        messageStr = messageStr.toUpperCase();
        EncryptedMessage message = new EncryptedMessage(messageStr);

        encrypted = message.getEncrypted();
        key = message.getKey();
        System.out.println(encrypted);
        for (int i=0; i<key.length;i++) {
            System.out.printf(key[i]+ " ");
        }

    }

}
