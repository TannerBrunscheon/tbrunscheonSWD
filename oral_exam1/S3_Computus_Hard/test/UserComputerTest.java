import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * Created by Tanner on 9/14/2016.
 */

public class UserComputerTest {
    @Test
    public void testEaster() throws Exception {
        Easter easter;
        int dayArray[] = {27,16,8,23,12,4,24,8,31,20,5,27,16,1,21,12,4,17,9,31,20};
        int monthArray[] = {3,4,4,3,4,4,4,4,3,4,4,3,4,4,4,4,4,4,4,3,4};
        // Source https://en.wikipedia.org/wiki/Easter
        int day;
        int month;
        int j =0;
        for (int i =2005;i<2026;i++) {
            easter = new Easter(i);
            day = easter.getDay();
            assertEquals(dayArray[j], day);
            month = easter.getMonth();
            assertEquals(monthArray[j], month);
            j++;
        }
    }
}
