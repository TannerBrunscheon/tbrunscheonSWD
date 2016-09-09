/**
 * Created by Tanner on 8/31/2016.
 */
import java.util.Scanner;
public class OTPMenu {
    private byte menuChoice = 1;
    private int key;
    Scanner input = new Scanner(System.in);
    private Message userMessage = new Message();

    public void runMenu(){
        while(menuChoice>0 && menuChoice<3){
            System.out.printf("Please Choose From the Following Options: %n1. Reset message %n2. Encrypt %n3. Decrypt %nInsert any other number to quit: ");
            menuChoice =input.nextByte();
            switch (menuChoice){
                case 1:{
                    userMessage.setMessage();
                }
                case 2:{
                    System.out.printf("Please enter your key value: ");
                    userMessage.encryptMessage();
                    System.out.printf("Input Message:  " + userMessage.getUnencryptedMessage() + "%n");
                    System.out.printf("Encrypted Message:  " + userMessage.getEncryptedMessage() + "%n");
                    System.out.printf("Key:  " + userMessage.getKey() + "%n");
                    break;
                }
                case 3:{
                    System.out.printf("Encrypted Message:  " + userMessage.getEncryptedMessage() + "%n");
                    System.out.printf("Key:  " + userMessage.getKey() + "%n%n");
                    userMessage.decryptMessage();
                    System.out.printf("%nDecrypted Message:  " + userMessage.getDecryptedMessage()+ "%n");
                    break;
                }

            }
        }
    }

}
