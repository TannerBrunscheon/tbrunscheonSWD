/**
 * Created by Tanner on 10/6/2016.
 */
public class LiberalArtsForeign extends ForeignStudent {
    /**
     * Constructor that fills out necessary information that user provides
     * @param firstName First name of student
     * @param lastName Last name of student
     * @param studentID Student ID
     * @param numberOfRegisteredHours Number of registered hours
     * @param studentStatus ENUM of the student status
     */
    public LiberalArtsForeign(String firstName, String lastName, String studentID, int numberOfRegisteredHours, StudentStatus studentStatus) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus);
    }

    /**
     * Constructor that fills out necessary information that user provides Same as other constuctor but allows student status as
     * a string
     * @param firstName First name of student
     * @param lastName Last name of student
     * @param studentID Student ID
     * @param numberOfRegisteredHours Number of registered hours
     * @param studentStatus String of the student status to be converted
     */
    public LiberalArtsForeign(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String studentStatus) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus);
    }

    /**
     * Sets the fees and hours required to get the fees and calls the generateTuition up the chain.
     * @return Number calculated
     */
    @Override
    public double generateTuition()
    {
        //Set feels and hours and go one up the tuition.
        super.setFees(400);
        super.setHours(3);
        return super.generateTuition();
    }
    /**
     * Adds tuition and college to the already generated string
     * @return String with Tuition and college added
     */
    @Override
    public String toString() {
        double tuition = generateTuition();
        return super.toString()+", College: " + "Liberal Arts"
                +", Total Tuition: " + tuition + "0";
    }
}
