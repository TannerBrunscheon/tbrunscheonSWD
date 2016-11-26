
/**
 * Main sorting class
 */
public class BucketSorting {
    /**
     * Given an  array of ints, sorts them using a bucket sort algorithm by sorting them based on number
     * in their 1 10s and 100s spots.
     * @param array Array to be sorted
     * @return Sorted array
     */
    public static int[] sort(int[] array) {
        int[][] bucket = new int[10][array.length - 1];//Buckets for sorting
        int[][] bucket2 = new int[10][array.length - 1];
        int[][] bucket3 = new int[10][array.length - 1];
        int k = 0;//Counter


        int[] amountPer = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};//2D array for the sorting alorithm
        //Add number to its spot on the 2D array based on the 1 spot 1-10
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] % 10][amountPer[array[i] % 10]] = array[i];
            amountPer[array[i] % 10]++;
        }

        //Convet the 2D array back to a 1D array
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (bucket[i][j] !=0){
                    array[k] = (bucket[i][j]);
                    k++;
                }
            }
        }
        //Add number to its spot on the 2D array based on the 10 spot 1-10
        amountPer = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < array.length; i++) {
            bucket2[array[i]/10 % 10][amountPer[array[i]/10 % 10]] = array[i];
            amountPer[array[i]/10 % 10]++;
        }

        k=0;
        //Convet the 2D array back to a 1D array
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (bucket2[i][j] !=0){
                    array[k] = (bucket2[i][j]);
                    k++;
                }
            }
        }
        //Add number to its spot on the 2D array based on the 100 spot 1-10
        amountPer = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < array.length; i++) {
            bucket3[array[i]/100][amountPer[array[i]/100]] = array[i];
            amountPer[array[i]/100]++;
        }
        k=0;
        //Convet the 2D array back to a 1D array
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (bucket3[i][j] !=0){
                    array[k] = (bucket3[i][j]);
                    k++;
                }
            }
        }
        return array;
    }
}
