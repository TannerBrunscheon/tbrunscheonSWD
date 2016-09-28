/**
 * Created by Tanner on 9/26/2016.
 */
public class Student {
    private String firstName = "Default";
    private String lastName = "Default";
    private String studentID = "Default";
    private double numberOfRegisteredHours = 0;
    private StudentStatus studentStatus = StudentStatus.DEFAULT;
    private CollegeEnrolled collegeEnrolled = CollegeEnrolled.DEFAULT;
    private double baseClassHourTuitionRate = 350;
    private double discountUnillFull = 1;
    private double discountAfter = 1;
    private double totalTuition;

    public Student(String firstName, String lastName, String studentID, int numberOfRegisteredHours, StudentStatus studentStatus, CollegeEnrolled collegeEnrolled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.numberOfRegisteredHours = numberOfRegisteredHours;
        this.studentStatus = studentStatus;
        this.collegeEnrolled = collegeEnrolled;
    }

    public Student(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String studentStatus, String collegeEnrolled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.numberOfRegisteredHours = numberOfRegisteredHours;
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
        switch (collegeEnrolled) {
            case ("Engineering"):
                this.collegeEnrolled = CollegeEnrolled.ENGINEERING;
                break;
            case ("Liberal Arts"):
                this.collegeEnrolled = CollegeEnrolled.LIBERALARTS;
                break;
            default:
                System.out.println("Invalid College. Setting to Default.");
                this.studentStatus = StudentStatus.DEFAULT;
                break;
        }
    }

    public double GenerateTuition(){
        if(numberOfRegisteredHours < studentStatus.getFullLoad())
        {
            totalTuition = (discountUnillFull*numberOfRegisteredHours*baseClassHourTuitionRate);
            if (numberOfRegisteredHours >= collegeEnrolled.getHours()) {
                totalTuition = totalTuition+collegeEnrolled.getFees();
            }
        }
        else
        {
            totalTuition = ((discountUnillFull*(studentStatus.getFullLoad()*baseClassHourTuitionRate))+
                    (discountAfter*((numberOfRegisteredHours-studentStatus.getFullLoad())*baseClassHourTuitionRate)));
            totalTuition =totalTuition+collegeEnrolled.getFees();
        }
        return totalTuition;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setNumberOfRegisteredHours(int numberOfRegisteredHours) {
        this.numberOfRegisteredHours = numberOfRegisteredHours;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public void setCollegeEnrolled(CollegeEnrolled collegeEnrolled) {
        this.collegeEnrolled = collegeEnrolled;
    }

    public void setBaseClassHourTuitionRate(int baseClassHourTuitionRate) {
        this.baseClassHourTuitionRate = baseClassHourTuitionRate;
    }

    public void setDiscountUnillFull(double discountUnillFull) {
        this.discountUnillFull = discountUnillFull;
    }

    public void setDiscountAfter(double discountAfter) {
        this.discountAfter = discountAfter;
    }

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
        switch (collegeEnrolled) {
            case ENGINEERING:
                out = out + ", College Enrolled: Engineering";
                break;
            case LIBERALARTS:
                out = out + ", College Enrolled: Liberal Arts";
                break;
            default:
                out = out + ", College Enrolled: Default";
                break;
        }
        return out;
    }
    public double getTuition(){return this.GenerateTuition();}
}