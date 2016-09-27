/**
 * Created by Tanner on 9/27/2016.
 */
public class ForeignStudent extends Student {
    private String placeOfResidence = "Foreign";
    public ForeignStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, StudentStatus studentStatus, CollegeEnrolled collegeEnrolled) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
    }

    public ForeignStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String studentStatus, String collegeEnrolled) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
    }

    @Override
    public double GenerateTuition()
    {
        super.setDiscountUnillFull(1.03);
        super.setDiscountAfter(1);
        return super.GenerateTuition();
    }
    @Override
    public String toString() {
        double tuition = GenerateTuition();
        return super.toString()+", Place of Residence: " + placeOfResidence
                +", Total Tuition: " + tuition;
    }

}
