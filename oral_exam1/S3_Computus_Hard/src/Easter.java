/**
 * Main class that does the Easter Computus calculation. It has a main method computeEaster that is only internally called
 * once. It is called during the constructor. The other methods in the class are getters and a toString method.
 */
public class Easter {
    /**
     *Year to be computed
     */
    private int year;
    /**
     * Final month computed
     */
    private int month;
    /**
     * Final day computed
     */
    private int day;

    /**
     * Sets value of year to be the value specified. Also computes easter using computerEaster method.
     * @param year Year that easter is to be computed for.
     */
    public Easter(int year) {
        this.year = year;
        computeEaster();
    }

    /**
     * Uses the algorithm on Wikipedia to compute the month and day of Easter based on the year.
     */
    private void computeEaster(){
        // This is set in stone comnpute easter
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        month = ((h + l - 7 * m + 114) / 31);
        day = ((h + l - 7 * m + 114) % 31)+1;
    }

    /**
     * Returns the month computed.
     * @return month computed
     */

    public int getMonth() {
        return month;
    }
    /**
     * Returns the day computed.
     * @return day computed
     */
    public int getDay(){
        return day;
    }

    /**
     * Sets the month day and year in a MM/DD/YYYY format as a string for easy readability
     * @return String of MM/DD/YYYY
     */
    @Override
    public String toString() {
        computeEaster();
        return "Easter " +
                month +
                "/" + day +
                "/" + year;
    }
}
