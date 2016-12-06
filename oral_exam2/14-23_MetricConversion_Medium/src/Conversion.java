import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Main converting class
 */
public class Conversion{
    /**
     * Hashmap of possible types and their conversions
     */
    public final static HashMap<String,Double> types = new HashMap<String,Double>();
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

    /**
     * Set of liquid measurements
     */
    public final static HashSet<String> liquids = new HashSet<>();
    static {
        liquids.add("liter");
        liquids.add("quart");
    }

    /**
     * Set of length mesurements
     */
    public final static HashSet<String> length= new HashSet<>();
    static {
        length.add("feet");
        length.add("inch");
        length.add("foot");
        length.add("yard");
        length.add("meter");
    }

    /**
     * Set of weight measurements
     */
    public static HashSet<String> weight= new HashSet<>();
    static {
        weight.add("pound");
        weight.add("gram");
    }

    /**
     * Set of prefixes and their values
     */
    public final static HashMap<String,Double> prefixes = new HashMap<String,Double>();
    static {
        prefixes.put("milli",.001);
        prefixes.put("centi",.01);
        prefixes.put("deci",.1);
        prefixes.put("deka",10.);
        prefixes.put("hecto",100.);
        prefixes.put("kilo",1000.);
    }

    /**
     * The main method for conversion. When giver the 2 types listed , an amount and a prefix, it will convert from
     * the first into the standard amount of the other kind.
     * @param type1 First type given by user
     * @param type2 Second type to check for matching types
     * @param amount Number to convert given by user
     * @param prefix Prefix on the first type
     * @return The converted amount
     */
    public static double Convert(String type1, String type2, double amount, String prefix) {
        double fullAmount;//Full amount after conversion
        double prefixAmount = 1;//Default prefix amount
        //Remove s and es
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
        // Check if the 2 types match
        if((liquids.contains(type1)&& liquids.contains(type2))|| (length.contains(type1)&& length.contains(type2))||(weight.contains(type1)&& weight.contains(type2))) {
           //Make word whole for conversion
            type1 =type1+prefix;
            for (int i = 0; i < 6; i++) {
                if (type1.contains(prefixes.keySet().toArray()[i].toString())) {//Grab the prefix value if the word contains a prefix
                    prefixAmount = prefixes.get(prefixes.keySet().toArray()[i]);
                }
            }
            for (int i = 0; i < 9; i++) {
                if (type1.contains(Conversion.types.keySet().toArray()[i].toString())) {
                    type1 = Conversion.types.keySet().toArray()[i].toString();//Find which units we are working with
                }
            }
            fullAmount = types.get(type1) * prefixAmount * amount; //Calculate amount
            return fullAmount;
        }
        throw new IllegalArgumentException("Types dont match");
    }





}
