/**
 * Created by Tanner on 9/13/2016.
 */
public class CycleComputer {
    public static void main(String[] args) {
        int march[] = new int[10];
        int april[] = new int[25];
        int month,day;
        Easter e = new Easter();

        for(int i=0; i<5700000; i++){
            e.setYear(i);
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
