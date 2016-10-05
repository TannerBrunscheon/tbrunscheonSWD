/**
 * Enumeration for the colleges that can be enrolled into. Mapped to each is additional student fees and the amount
 * of hours required to pay those fees.
 */
public enum CollegeEnrolled{
    /**
     * College of Liberal arts. 400$ fee and 3 hours required to pay fee.
     */
    LIBERALARTS(400,3),
    ENGINEERING(200,6),
    DEFAULT(0,0);

    private final int fees;
    private final int hours;

    CollegeEnrolled(int fees,int hours) {
        this.fees = fees;
        this.hours = hours;
    }

    public int getFees() {
        return fees;
    }

    public int getHours() {
        return hours;
    }
}
