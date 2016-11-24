/**
 * Main class used to test the morse code conversion algorithms.
 */
public class MorseDriver {

    public static void main(String[] args) {
        String message = "This is a really long message that I am using to test this program to make sure it works correctly";
        System.out. println(message);
        message = MorseConverstion.engtoMorse(message);
        System.out. println(message);
        message = MorseConverstion.morsetoEng(message);
        System.out. println(message);
    }
}
