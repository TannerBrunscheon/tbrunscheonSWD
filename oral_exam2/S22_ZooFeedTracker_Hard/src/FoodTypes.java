/**
 * This is the enumeration class that defines all the types of food that are supported.
 */
public enum FoodTypes {
    /**
     * Bass fish. In lbs
     */
    BASS("lbs") {
        @Override
        public String toString() {
            return "Bass";
        }
    },
    /**
     * Generic meat. In lbs
     */
    ZEBRAMEAT("lbs") {
        @Override
        public String toString() {
            return "Zebra Meat";
        }
    },
    /**
     * Hay food. In lbs
     */
    HAY("lbs")  {
        @Override
        public String toString() {
            return "Hay";
        }
    },
    /**
     * Peanut food type. In lbs
     */
    PEANUTS("lbs"){
        @Override
        public String toString() {
            return "Peanuts";
        }
    },
    /**
     * Shrimp food types. In lbs.
     */
    SHRIMP("lbs"){
        @Override
        public String toString() {
        return "Shrimp";
        }
};

    /**
     * The units that these food is measured in.
     */
    private final String units;

    /**
     * The constructor that sets up the enumeration type.
     * @param units The units that these food is measured in.
     */
    FoodTypes(String units) {
        this.units = units;
    }

    /**
     * Getting the units on the enumeration.
     * @return units of the enumeration
     */
    public String getUnits() {
        return units;
    }
}
