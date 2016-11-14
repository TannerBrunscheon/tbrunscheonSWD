import com.sun.org.apache.bcel.internal.generic.ConversionInstruction;

import java.util.Scanner;

/**
 * Created by tbrunscheon on 11/11/16.
 */
public class ConverterUI {
    private Scanner scanner = new Scanner(System.in);
    public ConverterUI() {
        runUI();
    }
    public void runUI(){
        System.out.println("Please enter your inquiry:");
        String message = scanner.nextLine();
        String type = "";
        String prefix = "";

        for (int i=0;i<6;i++){
            if(message.contains(Conversion.prefixes.keySet().toArray()[i].toString())){
                prefix = Conversion.prefixes.keySet().toArray()[i].toString();
            }
        }
        for (int i=0;i<6;i++){
            if(message.contains(Conversion.types.keySet().toArray()[i].toString())){
                type = Conversion.types.keySet().toArray()[i].toString();
            }
        }
        String amount = message.replaceAll("[^0-9]+", " ");
        Double finalAmount = Conversion.Convert(prefix+type,Double.parseDouble(amount));
        System.out.println(finalAmount);

    }
}
