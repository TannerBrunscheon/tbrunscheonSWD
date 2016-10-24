/**
 * Created by Tanner on 10/22/2016.
 */
public enum FoodTypes {
    BASS("lbs") {
        @Override
        public String toString() {
            return "Bass";
        }
    },
    ZEBRAMEAT("lbs") {
        @Override
        public String toString() {
            return "Zebra Meat";
        }
    },
    HAY("lbs")  {
        @Override
        public String toString() {
            return "Hay";
        }
    },
    PEANUTS("lbs"){
        @Override
        public String toString() {
            return "Peanuts";
        }
    },
    SHRIMP("lbs"){
        @Override
        public String toString() {
        return "Shrimp";
        }
};

    private final String units;

    FoodTypes(String units) {
        this.units = units;
    }

    public String getUnits() {
        return units;
    }
}
