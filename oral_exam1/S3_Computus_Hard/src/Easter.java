import java.time.Month;

/**
 * Created by Tanner on 8/31/2016.
 */
public class Easter {
    private int year;
    private int[] dayMonth;
    final static String MONTH[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};


    public Easter(int year) {
        this.year = year;
    }

    public void computeEaster(){

    }

    public String getMonth() {
        return MONTH[dayMonth[1]];
    }
    public int getDay(){
        return dayMonth[0];
    }
}
