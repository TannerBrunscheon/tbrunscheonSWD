/**
 * Created by Tanner on 8/31/2016.
 */
import java.util.Scanner;
public class OTPMenu {
    final static char  alphabet [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private byte menuChoice = 1;
    private int key;
    Scanner input = new Scanner(System.in);
    private Message userMessage = new Message();

    public void runMenu(){
        while(menuChoice>0 && menuChoice<3){
            System.out.printf("Please Choose From the Following Options: %n1. Encrypt %n2. Decrypt %nInsert any other number to quit: ");
            menuChoice =input.nextByte();
            switch (menuChoice){
                case 1:{
                    System.out.printf("Please enter your key value: ");
                    userMessage.encryptMessage();
                    System.out.printf("Input Message:  " + userMessage.getUnencryptedMessage());
                    System.out.printf("%nEncrypted Message:  " + userMessage.getEncryptedMessage() + "T%n");
                    System.out.printf("Key:  " + userMessage.getKey() + "%n%n");
                    break;
                }
                case 2:{
                    System.out.printf("Please enter your key value: ");
                    System.out.printf("%nEncrypted Message:  " + userMessage.getEncryptedMessage());
                    System.out.printf("%nKey:  " + userMessage.getKey() + "%n%n");
                    userMessage.decryptMessage();
                    System.out.printf("%nDecrypted Message:  " + userMessage.getDecryptedMessage()+ "%n");
                    break;
                }

            }
        }
    }

}
