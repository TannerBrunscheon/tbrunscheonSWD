import java.util.Arrays;
import java.util.Random;

/**
 * Driver for BucketSort that just generates a random array of numbers
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
