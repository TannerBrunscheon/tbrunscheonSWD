/**
 * Created by Tanner on 10/22/2016.
 */
public class Lion extends Animal {
    private static final FoodTypes[] EATABLE ={FoodTypes.BASS,FoodTypes.ZEBRAMEAT,FoodTypes.SHRIMP};
    public Lion(String animalName, String animalLocation) {
        super("Lion", animalName, animalLocation);
    }
}
