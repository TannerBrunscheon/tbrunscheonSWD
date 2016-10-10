import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Testing suite for the easter class. It uses an array of months and days of the specific years given by the for loop
 * and check that the output of the easter program matches it.
 * Source https://en.wikipedia.org/wiki/Easter
 */

public class UserComputerTest {
    @Test
    public void testEaster() throws Exception {
        /**
         * Easter class for computing
         */
        Easter easter;
        /**
         * Array of days of Easter from source from 2005 to 2025 in order
         */
        int dayArray[] = {27,16,8,23,12,4,24,8,31,20,5,27,16,1,21,12,4,17,9,31,20};
        /**
         * Array of months of Easter from source from 2005 to 2025 in order
         * Source https://en.wikipedia.org/wiki/Easter
         */
        int monthArray[] = {3,4,4,3,4,4,4,4,3,4,4,3,4,4,4,4,4,4,4,3,4};
        /**
         * Secondary counter for the 2 arrays.
         */
        int j =0;
        //For loop to look at the output of the Easter class. Make sure its right.
        for (int i =2005;i<2026;i++) {
            easter = new Easter(i);
            assertEquals(dayArray[j], easter.getDay());
            assertEquals(monthArray[j], easter.getMonth());
            j++;
        }
    }
}
