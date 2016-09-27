/**
 * Created by Tanner on 9/26/2016.
 */
public class Student {
    protected String firstName = "Default";
    protected String lastName = "Default";
    protected String studentID = "Default";
    protected double numberOfRegisteredHours = 0;
    protected StudentStatus studentStatus = StudentStatus.DEFAULT;
    protected CollegeEnrolled collegeEnrolled = CollegeEnrolled.DEFAULT;
    protected String placeOfResidence = "Default";
    protected double totalTuition = 0;
    protected double baseClassHourTuitionRate = 350;

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
            case ("Open enrolled"):
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
        totalTuition = (baseClassHourTuitionRate*numberOfRegisteredHours);
        if (numberOfRegisteredHours >= collegeEnrolled.getHours()) {
            totalTuition = totalTuition+collegeEnrolled.getFees();
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

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    public void setBaseClassHourTuitionRate(int baseClassHourTuitionRate) {
        this.baseClassHourTuitionRate = baseClassHourTuitionRate;
    }

}
