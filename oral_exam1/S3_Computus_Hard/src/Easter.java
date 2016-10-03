import com.sun.xml.internal.bind.v2.TODO;

import java.time.Month;

/**
 * Created by Tanner on 8/31/2016.
 */
public class Easter {
    private int year,month,day;

    public Easter(int year) {
        this.year = year;
    }
    public Easter(){}

    private void computeEaster(){
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        month = ((h + l - 7 * m + 114) / 31);
        day = ((h + l - 7 * m + 114) % 31)+1;
    }

    public int getMonth() {
        computeEaster();
        return month;
    }
    public int getDay(){
        computeEaster();
        return day;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        computeEaster();
        return "Easter " +
                month +
                "/" + day +
                "/" + year;
    }
}
