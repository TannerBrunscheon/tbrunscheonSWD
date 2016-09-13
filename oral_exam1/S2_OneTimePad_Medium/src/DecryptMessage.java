import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Tanner on 9/11/2016.
 */
public class DecryptMessage {
    public static void main(String[] args) {
        String messageStr;
        Scanner input = new Scanner(System.in);
        String decrypted;
        String keyTemp;
        String[] keyArray;
        int[] key;


        System.out.printf("Please Enter Your Encrypted Message: ");
        messageStr = input.nextLine();
        System.out.printf("Please Enter Your Key: ");
        keyTemp = input.nextLine();

        keyArray = keyTemp.split(" ");
        key= new int[keyArray.length];

        for (int i = 0; i< keyArray.length; i++)
        {
            key[i] = Integer.parseInt(keyArray[i]);
        }

        DecryptedMessage message = new DecryptedMessage(messageStr,key);

        decrypted = message.getDecrypted();
        System.out.println(decrypted);

    }
}
