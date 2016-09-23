/**
 * Created by Tanner on 9/22/2016.
 */
public enum FoodTypes {
    HORSEMEAT("LBS",5),
    DOGMEAT("LBS",5),
    HUMANMEAT("LBS",5),
    PENUTS("LBS",5),
    HAY("LBS",5),
    BASS("LBS", 1),
    BARK("LBS", 5),
    DEFAULT("DEFAULT", 0);

    // instance fields
    private final String unit;
    private final int perServing;

    // enum constructor
    FoodTypes(String unit, int perServing) {
        this.unit = unit;
        this.perServing = perServing;
    }

    public String getUnit() {
        return unit;
    }

    public int getPerServing() {
        return perServing;
    }
}

