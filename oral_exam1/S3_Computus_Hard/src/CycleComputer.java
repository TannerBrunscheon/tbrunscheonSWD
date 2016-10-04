/**
 * This program uses the Easter class to compute a cycle of Easters and display how many times that date comes up to the screen.
 * It only has a main class. It changes the year based on a for loop and computes the easters in an array based on the month, March
 * or April
 */
public class CycleComputer {
    public static void main(String[] args) {
        /**
         * March values. Its length is the possible days that easter could fall on.
         */
        int march[] = new int[10];
        /**
         * April values. Its length is the possible days that easter could fall on.
         */
        int april[] = new int[25];
        /**
         * Holding values for computations.
         */
        int month,day;
        /**
         * Easter class that will do the computation.
         */
        Easter e;

        for(int i=0; i<5700000; i++){
            e = new Easter(i);
            month = e.getMonth();
            day = e.getDay();
            if(month == 3){
                march[day-22]++;
            }
            else if(month == 4){
                april[day-1]++;
            }
        }

        for (int i = 0; i<10; i++) {
            System.out.printf("March " + (i+22) + "  " + march[i] + "%n");
        }
        for (int i = 0; i<25; i++) {
            System.out.printf("April " + (i+1) + "  " + april[i] + "%n");
        }
    }
}
