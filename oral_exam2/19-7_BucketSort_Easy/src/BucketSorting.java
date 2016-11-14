import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Tanner on 11/13/2016.
 */
public class BucketSorting {

    public static int[] sort(int[] array, int maxValue){
        int bucketNum;
        ArrayList<LinkedList<Integer>> bucketlist = new ArrayList<>(array.length);
        LinkedList<Integer> finalList = new LinkedList<>();

        for(int i = 0;i < array.length;i++){
            bucketNum = (array[i]*array.length)/(maxValue+1);
            if(bucketlist.get(bucketNum).size() == 0){
                bucketlist.get(bucketNum).add(array[i]);
            }
            else{
                for(int j = 0;j<bucketlist.get(bucketNum).size();i++){
                    if (j-1==bucketlist.get(bucketNum).size()){
                        bucketlist.get(bucketNum).add(array[i]);
                    }
                    else if (array[i]<bucketlist.get(bucketNum).get(j));
                    {
                        bucketlist.get(bucketNum).add(j,array[i]);
                    }

                }
            }

        }
        for (int i =0;i<bucketlist.size();i++) {
            finalList.addAll(bucketlist.get(i));
        }
        int[] finalArray= new int[finalList.size()];
        for (int i =0;i< finalList.size();i++){

            finalArray[i] = finalList.removeFirst();
        }
        return finalArray;



    }
}
