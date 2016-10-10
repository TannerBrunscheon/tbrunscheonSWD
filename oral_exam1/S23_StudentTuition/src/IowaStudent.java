/**
 * Created by Tanner on 9/27/2016.
 */
public class IowaStudent extends Student {
    /**
     * Constructor that fills out necessary information that user provides
     * @param firstName First name of student
     * @param lastName Last name of student
     * @param studentID Student ID
     * @param numberOfRegisteredHours Number of registered hours
     * @param studentStatus ENUM of the student status
     */
    public IowaStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, StudentStatus studentStatus) {
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
    public IowaStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String studentStatus) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus);
    }

    /**
     * Sets the discounts and calls the generateTuition up the chain.
     * @return Number calculated
     */
    @Override
    public double generateTuition()
    {
        //Change the discounts and generate tuition.
        super.setDiscountUnillFull(.65);
        super.setDiscountAfter(.9);
        return super.generateTuition();
    }

    /**
     * Adds place of residence to the already generated string
     * @return String with place of residence added
     */
    @Override
    public String toString() {
        return super.toString()+", Place of Residence: " + "Iowa";
    }
}
