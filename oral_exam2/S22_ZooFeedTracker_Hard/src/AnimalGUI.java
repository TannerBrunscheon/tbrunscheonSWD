import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tanner on 10/22/2016.
 */
public class AnimalGUI {
    private final ArrayList<Animal> animals = new ArrayList<Animal>();
    private Scanner input = new Scanner(System.in);
    public AnimalGUI() {
    }

    public void UserInterface(){

        int userChoice = 0;
        do{
            System.out.printf("Please Pick from the following list.%n1.Add new animal.%n2.Add feeding to an animal.%n3.See food eaten by animals.%n4.Generate grocery list for an individual.%n5.Generate whole grocery list.%n0.Exit Program%n");
            userChoice= input.nextInt();
            switch (userChoice){
                case 0:
                    break;
                case 1:
                    this.addAnimal();
                    break;
            }
        }while (userChoice != 0);
    }

    private void addAnimal(){
        boolean isDone = false;
        String animalName;
        String animalLocation;
        String animalType;
        System.out.println("Please enter your animals type: ");
        animalType = input.next();
        while (isDone == false) {
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
                    System.out.println("Not a valid animal!");
                }
            }
        }


    }

}
