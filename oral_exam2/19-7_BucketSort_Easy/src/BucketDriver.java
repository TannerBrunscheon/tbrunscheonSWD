import java.util.Arrays;
import java.util.Random;

/**
 * Created by Tanner on 11/14/2016.
 */
public class BucketDriver {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(array));
        array = BucketSorting.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
