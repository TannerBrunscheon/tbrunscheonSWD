/**
 * Created by Tanner on 9/26/2016.
 */
public class Student {
    /**
     * First name of student
     */
    private String firstName = "Default";
    /**
     * Last name of student
     */
    private String lastName = "Default";
    /**
     * Student id
     */
    private String studentID = "Default";
    /**
     * Number of hours registered
     */
    private double numberOfRegisteredHours = 0;
    /**
     * Enum the student status
     */
    private StudentStatus studentStatus = StudentStatus.DEFAULT;
    /**
     * Base tuition rate
     */
    private double baseClassHourTuitionRate = 350;
    /**
     * Discount until full time
     */
    private double discountUnillFull = 1;
    /**
     * Discount after full time
     */
    private double discountAfter = 1;
    /**
     * Fees for going to specific college
     */
    private int fees = 0;
    /**
     * Hours until fees take effect
     */
    private int hours = 0;

    /**
     * Constructor that fills out necessary information that user provides
     * @param firstName First name of student
     * @param lastName Last name of student
     * @param studentID Student ID
     * @param numberOfRegisteredHours Number of registered hours
     * @param studentStatus ENUM of the student status
     */
    public Student(String firstName, String lastName, String studentID, int numberOfRegisteredHours, StudentStatus studentStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.numberOfRegisteredHours = numberOfRegisteredHours;
        this.studentStatus = studentStatus;
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
    public Student(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String studentStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.numberOfRegisteredHours = numberOfRegisteredHours;
        //String to enum
        switch (studentStatus) {
            case ("Undergraduate"):
                this.studentStatus = StudentStatus.UNDERGRADUATE;
                break;
            case ("Graduate"):
                this.studentStatus = StudentStatus.GRADUATE;
                break;
            case ("Open Enrolled"):
                this.studentStatus = StudentStatus.OPENENROLLED;
                break;
            default:
                System.out.println("Invalid Student Status. Setting to Default.");
                this.studentStatus = StudentStatus.DEFAULT;
                break;
        }
    }

    /**
     * Implements the formula of discount times registered hours plus base class tuition rate added with
     * discount after hours are filled times registered hours plus base class tuition rate plus any fees.
     * @return Number computed from that thing
     */
    public double generateTuition(){
        double totalTuition;
        //If this is less than the full load then just do the caluclation straight forwards hours*tuition.
        if(numberOfRegisteredHours < studentStatus.getFullLoad())
        {
            totalTuition = (discountUnillFull*numberOfRegisteredHours*baseClassHourTuitionRate);
            //Add fees if you need to
            if (numberOfRegisteredHours >= hours) {
                totalTuition = totalTuition+fees;
            }
        }
        else
        {
            //Do the harder calculation which is full time hours * tuition+extra hours * tutuion +fees.
            totalTuition = ((discountUnillFull*(studentStatus.getFullLoad()*baseClassHourTuitionRate))+
                    (discountAfter*((numberOfRegisteredHours-studentStatus.getFullLoad())*baseClassHourTuitionRate)));
            totalTuition =totalTuition+fees;
        }
        return totalTuition;
    }

    /**
     * Change fees for calculation. Used by child classes
     * @param fees Fees child class specifies
     */
    protected void setFees(int fees) {
        this.fees = fees;
    }
    /**
     * Change hours for fees for calculation. Used by child classes
     * @param hours Hours for fees child class specifies
     */
    protected void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Allow public to change tuition rate
     * @param baseClassHourTuitionRate New tuition rate
     */
    public void setBaseClassHourTuitionRate(int baseClassHourTuitionRate) {
        this.baseClassHourTuitionRate = baseClassHourTuitionRate;
    }

    /**
     * Change discount until full time for calculation. Used by child classes
     * @param discountUnillFull New discount until full time
     */
    protected void setDiscountUnillFull(double discountUnillFull) {
        this.discountUnillFull = discountUnillFull;
    }
    /**
     * Change discount after full time for calculation. Used by child classes
     * @param discountAfter New discount after full time
     */
    protected void setDiscountAfter(double discountAfter) {
        this.discountAfter = discountAfter;
    }

    /**
     * toString overwrite to display useful information. Converts studentStatus to a string
     * @return Formatted string
     */
    @Override
    public String toString() {
        String out= "Student " +
                        "Name: '" + firstName + ' ' + lastName +
                        ", Student ID: " + studentID +
                        ", Number Of Registered Hours= " + numberOfRegisteredHours;
        switch (studentStatus) {
            case UNDERGRADUATE:
                out = out + ", Student Status: Undergraduate";
                break;
            case GRADUATE:
                out = out + ", Student Status: Graduate";
                break;
            case OPENENROLLED:
                out = out + ", Student Status: Open Enrolled";
                break;
            default:
                out = out + ", Student Status: Default";
                break;
        }
        return out;
    }
}