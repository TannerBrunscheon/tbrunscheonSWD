/**
 * Created by Tanner on 10/22/2016.
 */
public class Beaver extends Animal {
    private static final FoodTypes[] EATABLE ={FoodTypes.BASS,FoodTypes.SHRIMP,FoodTypes.HAY};
    public Beaver(String animalName, String animalLocation) {
        super("Beaver", animalName, animalLocation);
    }
}
