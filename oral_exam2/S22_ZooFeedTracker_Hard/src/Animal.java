import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tanner on 10/22/2016.
 */
public class Animal {
    private String animalType = "Default";
    private String animalName = "Default";
    private String animalLocation = "Default";
    private final ArrayList<FoodTypes> feedingTypes = new ArrayList<>();
    private final ArrayList<Integer> feedingAmounts = new ArrayList<>();

    public Animal(String animalType, String animalName, String animalLocation) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalLocation = animalLocation;
    }

    public String getAnimalType() {
        return animalType;
    }

    protected void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalLocation() {
        return animalLocation;
    }

    protected void setAnimalLocation(String animalLocation) {
        this.animalLocation = animalLocation;
    }

    public ArrayList<String> getFoodTypes() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (FoodTypes f : FoodTypes.values()) {
            arrayList.add(f.toString());
        }
        return arrayList;
    }

    public void addFeeding(FoodTypes foodTypes,int number){

        for (int j = 0; j<feedingTypes.size();j++) {
            if(feedingTypes.get(j) == foodTypes)
            {
                j= feedingTypes.size();
                feedingAmounts.set(j,feedingAmounts.get(j)+number);
            }
            else if (j+1 == feedingTypes.size())
            {
                feedingTypes.add(foodTypes);
                feedingAmounts.add(number);
            }
        }

    }

    public HashMap<FoodTypes,Integer> getFeedingTotals(){
        HashMap<FoodTypes, Integer> hashMap = new HashMap<FoodTypes, Integer>();
        for (int i = 0; i<feedingTypes.size();i++) {
            hashMap.put(feedingTypes.get(i),feedingAmounts.get(i));
        }
        return hashMap;
    }
    @Override
    public String toString() {
        return "Name: "+ getAnimalName() + "   Type: " +  getAnimalType() + "   Location: " +getAnimalLocation();
    }
}
