import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Scanner;

/**
 * Created by Tanner on 8/31/2016.
 */
public class UserComputer {
    public static void main(String[] args) {
        final String[] MONTH = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int year;
        Scanner input = new Scanner(System.in);


        System.out.printf("Please Enter the Year: ");
        year = input.nextInt();
        Easter e = new Easter(year);
        System.out.printf(MONTH[e.getMonth()] + " " + e.getDay()+ " " + year);
    }
    //TODO add testing software
}
