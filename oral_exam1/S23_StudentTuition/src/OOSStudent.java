/**
 * Created by Tanner on 9/27/2016.
 */
public class OOSStudent extends Student {
    private String placeOfResidence = "Out of State";
    public OOSStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, StudentStatus studentStatus, CollegeEnrolled collegeEnrolled) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
    }

    public OOSStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String studentStatus, String collegeEnrolled) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
    }


    @Override
    public double GenerateTuition()
    {
        super.setDiscountUnillFull(1);
        super.setDiscountAfter(1);
        return super.GenerateTuition();
    }
    @Override
    public String toString() {
        double tuition = GenerateTuition();
        return super.toString()+", Place of Residence: " + placeOfResidence
                +", Total Tuition: " + tuition+ "0";
    }
}
