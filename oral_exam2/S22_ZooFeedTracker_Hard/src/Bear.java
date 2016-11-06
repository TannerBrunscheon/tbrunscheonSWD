import java.util.ArrayList;

/**
 * Created by Tanner on 10/22/2016.
 */
public class Bear extends Animal {
    private static final FoodTypes[] EATABLE ={FoodTypes.BASS,FoodTypes.PEANUTS};
    public Bear(String animalName, String animalLocation) {
        super("Bear", animalName, animalLocation);
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
