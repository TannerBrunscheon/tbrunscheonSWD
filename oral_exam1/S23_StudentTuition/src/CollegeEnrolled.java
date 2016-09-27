/**
 * Created by Tanner on 9/27/2016.
 */
public enum CollegeEnrolled{
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
