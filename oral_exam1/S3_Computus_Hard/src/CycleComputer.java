/**
 * Created by Tanner on 9/13/2016.
 */
public class CycleComputer {
    public static void main(String[] args) {
        int march[] = new int[10];
        int april[] = new int[25];
        Easter e = new Easter();

        for(int i=0; i<5700000; i++){
            e.setYear(i);
            if(e.getMonth() == 2){
                march[e.getDay()-22] = march[e.getDay()-22]++;
            }
            else if(e.getMonth() == 3){
                april[e.getDay()] = april[e.getDay()-22]++;
            }
        }
        //TODO add printing to this
    }
}
