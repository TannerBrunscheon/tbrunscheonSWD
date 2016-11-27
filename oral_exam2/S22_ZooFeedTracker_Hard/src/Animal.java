import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tanner on 10/22/2016.
 */
public class Animal {
    private String animalType = "Default"; //Animal type
    private String animalName = "Default"; //Name
    private String animalLocation = "Default";  //Location
    private final ArrayList<FoodTypes> feedingTypes = new ArrayList<>(); //Array list for types of food fed to animals
    private final ArrayList<Integer> feedingAmounts = new ArrayList<>(); //Feeding amounts "mapped" to feeding types

    public Animal(String animalType, String animalName, String animalLocation) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalLocation = animalLocation;
    }

    public String getAnimalType() {
        return animalType;
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

    /**
     * Get all food types
     * @return all food types
     */
    public ArrayList<String> getFoodTypes() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (FoodTypes f : FoodTypes.values()) {
            arrayList.add(f.toString());
        }
        return arrayList;
    }

    /**
     * Add feeding to animal
     * @param foodTypes type of food
     * @param number number of food
     */
    public void addFeeding(FoodTypes foodTypes,int number){
        for (int j = 0; j<=feedingTypes.size();j++) {
            //Check if its the first feeding
            if (feedingTypes.size()==0)
            {
                //Add food and break for loop
                feedingTypes.add(foodTypes);
                feedingAmounts.add(number);
                j=feedingTypes.size();
            }
            else {
                if (feedingTypes.get(j) == foodTypes) {
                    //If feeding type is found add the amount to the already found value
                    feedingAmounts.set(j, feedingAmounts.get(j) + number);
                    j = feedingTypes.size();
                } else if (j + 1 == feedingTypes.size()) {
                    //If feeding type isn't feed already add the type and number
                    feedingTypes.add(foodTypes);
                    feedingAmounts.add(number);
                }
            }
        }

    }

    /**
     * Get the feeding total for this animal
     * @return Hashmap of type of food and its amount that has been fed
     */
    public HashMap<FoodTypes,Integer> getFeedingTotals(){
        HashMap<FoodTypes, Integer> hashMap = new HashMap<FoodTypes, Integer>();//Hashmap to return
        for (int i = 0; i<feedingTypes.size();i++) {
            //put the feeding type and its amount to the hashmap
            hashMap.put(feedingTypes.get(i),feedingAmounts.get(i));
        }
        return hashMap;
    }
    @Override
    public String toString() {
        return "Name: "+ getAnimalName() + "   Type: " +  getAnimalType() + "   Location: " +getAnimalLocation();
    }
}
