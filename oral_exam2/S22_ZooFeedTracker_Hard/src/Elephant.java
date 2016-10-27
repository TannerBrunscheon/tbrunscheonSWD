/**
 * Created by Tanner on 10/22/2016.
 */
public class Elephant extends Animal {
    private static final FoodTypes[] EATABLE ={FoodTypes.BASS,FoodTypes.PEANUTS,FoodTypes.ZEBRAMEAT};
    public Elephant(String animalName, String animalLocation) {
        super("Elephant", animalName, animalLocation);
    }
}
