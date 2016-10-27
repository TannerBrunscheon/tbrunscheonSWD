/**
 * Created by Tanner on 10/22/2016.
 */
public class Snake extends Animal {
    private static final FoodTypes[] EATABLE ={FoodTypes.BASS,FoodTypes.ZEBRAMEAT};
    public Snake(String animalName, String animalLocation) {
        super("Snake", animalName, animalLocation);
    }
}
