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
        String keyTemp;
        String[] keyArray;
        int[] key;


        System.out.printf("Please Enter Your Encrypted Message: ");
        messageStr = input.nextLine();
        System.out.printf("Please Enter Your Key: ");
        keyTemp = input.nextLine();

        keyArray = keyTemp.split(" ");
        key= new int[keyArray.length];
        try {
            if (keyArray.length<messageStr.length()){
                throw new IllegalArgumentException("Key too long");
            }
            else {
                for (int i = 0; i < keyArray.length; i++) {
                    key[i] = Integer.parseInt(keyArray[i]);
                }
            }
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("Key not string of numbers");
        }
        catch (ArrayIndexOutOfBoundsException e ){
            throw new IllegalArgumentException("Key too short");
        }
        DecryptedMessage message = new DecryptedMessage(messageStr.toUpperCase(),key);
        System.out.println(message);

    }
}
