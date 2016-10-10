
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is a user input interface for the Easter class. It takes in a value of the year to be computed from the year
 * and gives the output by both reading from a string of months and days and formatting a string on its own and using the
 * toString method in the Easter class.
 */
public class UserComputer {
    public static void main(String[] args) {
        /**
         * String of months with a NULL in front. This only needs to go until April but since this is a driver class
         * I wanted to show the program returns the number of the month and thus I needed to make March 3 and April 4.
         */
        final String[] MONTH = {"NULL", "January", "February", "March", "April"};
        /**
         * Holds the year that is input by the User.
         */
        int year;
        /**
         * Scanner for user input
         */
        Scanner input = new Scanner(System.in);

        //Get user input and print the day and month both ways avalable. It there is an error prompt the user
        //that they made a mistake
        System.out.printf("Please Enter the Year: ");
        try {
            year = input.nextInt();
            Easter e = new Easter(year);
            System.out.print(MONTH[e.getMonth()] + " " + e.getDay()+ " " + year+ "\n");
            System.out.println(e);
        }
        catch (InputMismatchException e)
        {
            throw new InputMismatchException("Please enter a year between -2147483647 and  2147483647");
        }


    }
}
