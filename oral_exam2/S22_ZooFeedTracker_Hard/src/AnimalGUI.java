import java.util.*;

/**
 * Main class for the gui.
 */
public class AnimalGUI {
    /**
     * List of animals created.
     */
    private final ArrayList<Animal> animals = new ArrayList<Animal>();
    /**
     * Input
     */
    private Scanner input = new Scanner(System.in);

    /**
     * Constructor that starts the GUI.
     */
    public AnimalGUI() {
        UserInterface();
    }

    /**
     * This is the user interface itself. It allows a user to choose what it wants from a menu and then calls the
     * approriate method.
     */
    public void UserInterface(){

        int userChoice;
        do{
            //Get user choice from menu
            System.out.printf("Please Pick from the following list.%n1.Add new animal.%n2.Add feeding to an animal.%n" +
                    "3.See food eaten by animals.%n4.Generate grocery list for an individual.%n" +
                    "5.Generate whole grocery list.%n0.Exit Program%n");
            userChoice= input.nextInt();
            switch (userChoice){
                case 0://Exit
                    break;
                case 1://Add animal
                    this.addAnimal();
                    break;
                case 2://Add feeding
                    this.addFeeding();
                    break;
                case 3://What can the animal eat
                    this.checkFeeding();
                    break;
                case 4://Individual grocery list
                    this.indiGrocery();
                    break;
                case 5://Full grocery list
                    this.fullGrocery();
                    break;

            }
        }while (userChoice != 0);
    }

    /**
     * This method receives an input from the user and makes that input into a animal class of thee appropriate type.
     * It has a default value that loops until a valid animal
     */
    private void addAnimal(){
        boolean isDone = false;
        String animalName; //Name
        String animalLocation; //Location
        String animalType; //Type
        //Get user type input
        System.out.println("Please enter your animals type: ");
        animalType = input.next();
        while (isDone == false) {
            //Get animal type and take in its name and location and add it to the list of animals
            switch (animalType) {
                case "Bear": {
                    System.out.println("Please enter your animals name: ");
                    animalName = input.next();
                    System.out.println("Please enter your animals location: ");
                    animalLocation = input.next();
                    animals.add(new Bear(animalName, animalLocation));
                    isDone=true;
                    break;
                }
                case "Beaver": {
                    System.out.println("Please enter your animals name: ");
                    animalName = input.next();
                    System.out.println("Please enter your animals location: ");
                    animalLocation = input.next();
                    animals.add(new Beaver(animalName, animalLocation));
                    isDone=true;
                    break;
                }
                case "Dolphin": {
                    System.out.println("Please enter your animals name: ");
                    animalName = input.next();
                    System.out.println("Please enter your animals location: ");
                    animalLocation = input.next();
                    animals.add(new Dolphin(animalName, animalLocation));
                    isDone=true;
                    break;
                }
                case "Elephant": {
                    System.out.println("Please enter your animals name: ");
                    animalName = input.next();
                    System.out.println("Please enter your animals location: ");
                    animalLocation = input.next();
                    animals.add(new Elephant(animalName, animalLocation));
                    isDone=true;
                    break;
                }
                case "Lion": {
                    System.out.println("Please enter your animals name: ");
                    animalName = input.next();
                    System.out.println("Please enter your animals location: ");
                    animalLocation = input.next();
                    animals.add(new Lion(animalName, animalLocation));
                    isDone=true;
                    break;
                }
                case "Snake": {
                    System.out.println("Please enter your animals name: ");
                    animalName = input.next();
                    System.out.println("Please enter your animals location: ");
                    animalLocation = input.next();
                    animals.add(new Snake(animalName, animalLocation));
                    isDone=true;
                    break;
                }
                default:
                {
                    //Not a real animal retry
                    System.out.println("Not a valid animal!");
                }
            }
        }
    }

    /**
     * This method gets a user input for which animal the user wants to add feeding for, iterates through the possible
     * food choices and adds the selected food type and amount to the class
     */
    private void addFeeding(){
        int animalChoice;
        int foodChoice;
        int amount;
        //Print list of animals and get user choice
        System.out.println("Choose your animal: ");
        for (int i =0; i<animals.size();i++)
        {
            System.out.println((i+1)+". "+animals.get(i).toString());
        }
        animalChoice = input.nextInt()-1;
        //Print list of fppd and get user choice
        System.out.println("Choose your food: ");
        ArrayList<String> foodTypes = animals.get(animalChoice).getFoodTypes();
        for (int i =0; i<foodTypes.size();i++){
            System.out.println((i+1)+". "+foodTypes.get(i));
        }
        foodChoice = input.nextInt()-1;

        switch (foodTypes.get(foodChoice)){
            //Based on the food choice get the amount of food and make them eat it
            case "Bass":
                System.out.println("Enter amount in " + FoodTypes.BASS.getUnits());
                amount = input.nextInt();
                animals.get(animalChoice).addFeeding(FoodTypes.BASS,amount);
                break;
            case "Zebra Meat":
                System.out.println("Enter amount in " + FoodTypes.ZEBRAMEAT.getUnits());
                amount = input.nextInt();
                animals.get(animalChoice).addFeeding(FoodTypes.ZEBRAMEAT,amount);
                break;
            case "Hay":
                System.out.println("Enter amount in " + FoodTypes.HAY.getUnits());
                amount = input.nextInt();
                animals.get(animalChoice).addFeeding(FoodTypes.HAY,amount);
                break;
            case "Peanuts":
                System.out.println("Enter amount in " + FoodTypes.PEANUTS.getUnits());
                amount = input.nextInt();
                animals.get(animalChoice).addFeeding(FoodTypes.PEANUTS,amount);
                break;
            case "Shrimp":
                System.out.println("Enter amount in " + FoodTypes.SHRIMP.getUnits());
                amount = input.nextInt();
                animals.get(animalChoice).addFeeding(FoodTypes.SHRIMP,amount);
                break;
        }
    }

    /**
     * This method grabs the food from an individual animal specified from the user and prints it to the screen.
     */
    private void indiGrocery(){
        int animalChoice;
        System.out.println("Choose your animal: ");
        //Print list of animals and get user choice
        for (int i =0; i<animals.size();i++)
        {
            System.out.println((i+1)+". "+animals.get(i).toString());
        }
        animalChoice = input.nextInt()-1;
        //Get the feeding amounts for the animal
        HashMap<FoodTypes,Integer> foodTypesIntegerHashMap = animals.get(animalChoice).getFeedingTotals();
        //Grab all the keys from the hashmap
        Object[] key = foodTypesIntegerHashMap.keySet().toArray();
        //Print out the hashmap
        for(int i = 0; i< key.length;i++){
            System.out.print(key[i]+":  ");
            System.out.println(foodTypesIntegerHashMap.get(key[i]));
        }
    }

    /**
     * This method iterates through all of the animals keeping a running count of food eaten by animals. Then prints the
     * count to the screen.
     */
    private void fullGrocery(){
        //Amounts of feeding per type
        int[] amounts = new int[5];
        //Foods
        Object[] foods = {FoodTypes.BASS,FoodTypes.ZEBRAMEAT,FoodTypes.HAY,FoodTypes.PEANUTS,FoodTypes.SHRIMP};
        //Get all the animals feedings
        for (int i =0; i<animals.size();i++)
        {
            //Get the ith animals feedings
            HashMap<FoodTypes,Integer> foodTypesIntegerHashMap = animals.get(i).getFeedingTotals();
            //Get the keys from the animals
            Object[] key = foodTypesIntegerHashMap.keySet().toArray();
            //Look for the type in the animals feeding and add it to the overall amount
            for (int k =0;k<key.length;k++){
                Object keything = key[k];
                for(int l =0; l<foods.length;l++) {
                    if (keything == foods[l]) {
                        amounts[l] = amounts[l] + foodTypesIntegerHashMap.get(key[l]);
                    }
                }
            }
            //Print out the feeding amounts
            for(int j = 0; j< foods.length;j++){
                System.out.printf(foods[j]+": "+amounts[j] + "%n");
            }
        }
    }

    /**
     * Print to the screen what the animal can eat.
     */
    private void checkFeeding(){
        int animalChoice;
        System.out.println("Choose your animal: ");
        //Print list of animals and get user choice
        for (int i =0; i<animals.size();i++)
        {
            System.out.println((i+1)+". "+animals.get(i).toString());
        }
        animalChoice = input.nextInt()-1;
        //Get the foods that the animal can eat
        ArrayList<String> foodTypes = animals.get(animalChoice).getFoodTypes();
        //Print foods that that animal can eat
        for (int i =0; i<foodTypes.size();i++){
            System.out.println((i+1)+". "+foodTypes.get(i));
        }
    }
}

