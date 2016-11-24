import java.util.ArrayList;

/**
 * This is the dolphin inhearted class from Animal
 */
public class Dolphin extends Animal {
    /**
     * An array that holds the foods that the animal eats
     */
    private static final FoodTypes[] EATABLE ={FoodTypes.BASS,FoodTypes.SHRIMP};
    /**
     *  Constructor that autofills the animal type parameter automatically with its type of animal based on
     *  the class created
     * @param animalName Name of the animal
     * @param animalLocation Locaton of the animal
     */
    public Dolphin(String animalName, String animalLocation) {
        super("Dolphins", animalName, animalLocation);
    }
    /**
     * Returns a list in ArrayList format that is filled with the types of food the animal eats
     * @return list of possible food types
     */
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
