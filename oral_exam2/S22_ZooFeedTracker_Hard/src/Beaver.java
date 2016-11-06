import java.util.ArrayList;

/**
 * Created by Tanner on 10/22/2016.
 */
public class Beaver extends Animal {
    private static final FoodTypes[] EATABLE ={FoodTypes.BASS,FoodTypes.SHRIMP,FoodTypes.HAY};
    public Beaver(String animalName, String animalLocation) {
        super("Beaver", animalName, animalLocation);
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
