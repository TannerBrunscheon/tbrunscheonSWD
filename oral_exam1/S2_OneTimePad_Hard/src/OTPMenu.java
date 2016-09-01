/**
 * Created by Tanner on 8/31/2016.
 */
import java.util.Scanner;
public class OTPMenu {
    final static char  alphabet [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private byte menuChoice = 1;
    Scanner input = new Scanner(System.in);

    public void runMenu(){
        while(menuChoice>0){
            System.out.printf("Please Choose From the Following Options: %n1. Input Message%n2. Encrypt Message%n3. Decrypt Message %n");
            menuChoice =input.nextByte();
            switch (menuChoice){
                case 1:{
                    Message userMessage = new Message();
                    userMessage.encryptMessage();
                    System.out.printf("Input Message:  " + userMessage.getUnencryptedMessage());
                    System.out.printf("%nEncrypted Message:  " + userMessage.getEncrypedMessage());
                    System.out.printf("%nKey:  " + userMessage.getKey() +"%n%n");
                }
            }
        }
    }

}
