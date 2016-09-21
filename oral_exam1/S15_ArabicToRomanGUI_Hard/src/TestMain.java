import java.util.Scanner;

/**
 * Created by Tanner on 9/20/2016.
 */
public class TestMain {
    public static void main(String[] args) {
        String messageStr;
        Scanner input = new Scanner(System.in);


        System.out.printf("Please Enter Your Roman Numeral");
        messageStr = input.nextLine();
        RomanConverter test = new RomanConverter(messageStr.toUpperCase());
        System.out.println(test);
    }

}

