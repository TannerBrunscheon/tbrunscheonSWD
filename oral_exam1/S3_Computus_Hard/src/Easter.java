import java.time.Month;

/**
 * Created by Tanner on 8/31/2016.
 */
public class Easter {
    private int year,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p;
    private int[] dayMonth;
    private static final String[] MONTH = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};


    public Easter(int year) {
        this.year = year;
    }

    public void computeEaster(){
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
        int n = (h + l - 7 * m + 114) / 31;
        int p = (h + l - 7 * m + 114) % 31;


    }

    public String getMonth() {
        return MONTH[dayMonth[1]];
    }
    public int getDay(){
        return dayMonth[0];
    }



}
