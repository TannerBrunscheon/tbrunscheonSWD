import java.util.ArrayList;

/**
 * Created by Tanner on 10/22/2016.
 */
public class Dolphin extends Animal {
    private static final FoodTypes[] EATABLE ={FoodTypes.BASS,FoodTypes.SHRIMP};
    public Dolphin(String animalName, String animalLocation) {
        super("Dolphins", animalName, animalLocation);
    }
    @Override
    public ArrayList<String> getFoodTypes(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < EATABLE.length; i++)
        {
            arrayList.add(EATABLE[i].toString());
        }
        return arrayList;
    }

}
