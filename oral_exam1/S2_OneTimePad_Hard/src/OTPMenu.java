/**
 * Created by Tanner on 8/31/2016.
 */
import java.util.Scanner;
public class OTPMenu {
    private byte menuChoice = 1;

    private Message userMessage = new Message();
    Scanner input = new Scanner(System.in);
    public void runMenu(){
        while(menuChoice>0 && menuChoice<4){
            System.out.printf("Please Choose From the Following Options: %n1. Reset message %n2. Encrypt %n3. Decrypt %nInsert any other number to quit: ");
            menuChoice =input.nextByte();
            switch (menuChoice){
                case 1:{
                    userMessage.setMessage();
                    break;
                }
                case 2:{
                    userMessage.encryptMessage();
                    System.out.printf("Input Message:  " + userMessage.getUnencryptedMessage() + "%n");
                    System.out.printf("Encrypted Message:  " + userMessage.getEncryptedMessage() + "%n");
                    System.out.printf("Key:  " + userMessage.getKey() + "%n");
                    break;
                }
                case 3:{
                    System.out.printf("Encrypted Message:  " + userMessage.getEncryptedMessage() + "%n");
                    System.out.printf("Key:  " + userMessage.getKey() + "%n");
                    userMessage.decryptMessage();
                    System.out.printf("%nDecrypted Message:  " + userMessage.getDecryptedMessage()+ "%n");
                    break;
                }

            }
        }
    }

}
