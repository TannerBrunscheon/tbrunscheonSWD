import com.sun.org.apache.bcel.internal.generic.ConversionInstruction;

import java.util.Scanner;

/**
 * Gui for the conversion class. It parse for 2 strings and an integer and feeds that and its prefix into the program
 */
public class ConverterUI {
    /**
     * User input.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor that starts the UI
     */
    public ConverterUI() {
        runUI();
    }
    /**
     * Allows the user to enter a sentence for consideration and converts that sentence.
     */
    public void runUI(){
        //Get inquiry
        System.out.println("Please enter your inquiry:");
        String message = scanner.nextLine();
        String[] type = new String[2]; //Strings of the units
        String prefix = "";
        int k= 0; //Counter
        //Grab the prefix from the word
        for (int i=0;i<6;i++){
            if(message.contains(Conversion.prefixes.keySet().toArray()[i].toString())){
                prefix = Conversion.prefixes.keySet().toArray()[i].toString();
            }
        }
        //Grab the units from the sentence
        for (int i=0;i<9;i++){
            if(message.contains(Conversion.types.keySet().toArray()[i].toString())||message.contains(Conversion.types.keySet().toArray()[i].toString()+"s")||message.contains(Conversion.types.keySet().toArray()[i].toString()+"es")){

                type[k] = Conversion.types.keySet().toArray()[i].toString();
                k++;
            }
        }
        //If the first unit comes before the second then switch the order
        if (message.toLowerCase().indexOf(type[0])<message.toLowerCase().indexOf(type[1])){
            String temp = type[0];
            type[0]=type[1];
            type[1]=temp;
        }

        //Replace nonnumbers with nothing to grab the number
        String amount = message.replaceAll("[^0-9]+", " ");
        Double finalAmount = Conversion.Convert(type[1],type[0], Double.parseDouble(amount),prefix);
        //Print out amount
        System.out.println(finalAmount+ " " +type[1]);

    }
}
