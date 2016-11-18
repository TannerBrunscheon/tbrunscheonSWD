import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tbrunscheon on 11/11/16.
 */
public class Conversion{
    public static HashMap<String,Double> types = new HashMap<String,Double>();
    static {
        types.put("liter",1.05669);
        types.put("quart",0.946353);
        types.put("foot",3.280841666667);
        types.put("feet",3.280841666667);
        types.put("inch",39.3701);
        types.put("yard",1.0936138888889999077);
        types.put("meter",0.30480016459203096435);
        types.put("pound",453.592);
        types.put("gram",0.00220462);

    }
    public static HashSet<String> liquids = new HashSet<>();
    static {
        liquids.add("liter");
        liquids.add("quart");
    }
    public static HashSet<String> length= new HashSet<>();
    static {
        length.add("feet");
        length.add("inch");
        length.add("foot");
        length.add("yard");
        length.add("meter");
    }
    public static HashSet<String> weight= new HashSet<>();
    static {
        weight.add("pound");
        weight.add("gram");
    }
    public static HashMap<String,Double> prefixes = new HashMap<String,Double>();
    static {
        prefixes.put("milli",.001);
        prefixes.put("centi",.01);
        prefixes.put("deci",.1);
        prefixes.put("deka",10.);
        prefixes.put("hecto",100.);
        prefixes.put("kilo",1000.);
    }

    public static double Convert(String type1, String type2, double amount) {
        double fullAmount;
        double prefixAmount = 1;
        if (type1.endsWith("es")) {
            type1 = type1.substring(0, type1.length() - 2);
        } else if (type1.endsWith("s")) {
            type1 = type1.substring(0, type1.length() - 1);
        }
        if (type2.endsWith("es")) {
            type1 = type1.substring(0, type1.length() - 2);
        } else if (type2.endsWith("s")) {
            type1 = type1.substring(0, type1.length() - 1);
        }
        if((liquids.contains(type1)&& liquids.contains(type2))|| (length.contains(type1)&& length.contains(type2))||(weight.contains(type1)&& weight.contains(type2))) {

            for (int i = 0; i < 6; i++) {
                if (type1.contains(prefixes.keySet().toArray()[i].toString())) {
                    prefixAmount = prefixes.get(prefixes.keySet().toArray()[i]);
                }
            }
            for (int i = 0; i < 6; i++) {
                if (type1.contains(Conversion.types.keySet().toArray()[i].toString())) {
                    type1 = Conversion.types.keySet().toArray()[i].toString();
                }
            }
            fullAmount = types.get(type1) * prefixAmount * amount;
            return fullAmount;
        }
        throw new IllegalArgumentException("Types dont match");
    }





}
