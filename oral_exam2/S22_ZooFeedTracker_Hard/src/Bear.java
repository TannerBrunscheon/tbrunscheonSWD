/**
 * Created by Tanner on 10/22/2016.
 */
public class Bear extends Animal {
    private static final FoodTypes[] EATABLE ={FoodTypes.BASS,FoodTypes.PEANUTS};
    public Bear(String animalName, String animalLocation) {
        super("Bear", animalName, animalLocation);
    }
}
