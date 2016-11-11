import java.util.HashMap;

/**
 * Created by tbrunscheon on 11/11/16.
 */
public class Conversion{
    private static HashMap<String,Double> types = new HashMap<String,Double>();
    {
        types.put("liter",1.05669);
        types.put("quart",0.946353);
        types.put("foot",0.3048);
        types.put("feet",0.3048);
        types.put("inch",0.0254);
        types.put("yard",0.9144);
        types.put("meter",3.28084);
        types.put("pound",453.592);
        types.put("gram",0.00220462);

    }
    private static HashMap<String,Double> prefixes = new HashMap<String,Double>();
    {
        prefixes.put("milli",1000.0);
        prefixes.put("centi",100.0);
        prefixes.put("deci",10.0);
        prefixes.put("deka",.1);
        prefixes.put("hecto",.01);
        prefixes.put("kilo",.001);
    }

    public static double Convert(String type, double amount) {
        double fullAmount;
        double prefixAmount = 1;
        if (type.endsWith("es")){
            type =type.substring(0,type.length()-2);
        }
        else if (type.endsWith("s")) {
            type =type.substring(0,type.length()-1);
        }
        for (int i=0;i<6;i++){
            if(type.contains(prefixes.keySet().toArray()[i].toString())){
                prefixAmount = prefixes.get(prefixes.keySet().toArray()[i]);
            }
        }
        fullAmount = types.get(type) * prefixAmount * amount;
        return fullAmount;
    }





}
