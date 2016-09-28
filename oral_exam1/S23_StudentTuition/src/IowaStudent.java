/**
 * Created by Tanner on 9/27/2016.
 */
public class IowaStudent extends Student {
    private String placeOfResidence = "Iowa";
    public IowaStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, StudentStatus studentStatus, CollegeEnrolled collegeEnrolled) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
    }

    public IowaStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String studentStatus, String collegeEnrolled) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
    }

    @Override
    public double GenerateTuition()
    {
        super.setDiscountUnillFull(.65);
        super.setDiscountAfter(.9);
        return super.GenerateTuition();
    }

    @Override
    public String toString() {
        double tuition = GenerateTuition();
        return super.toString()+", Place of Residence: " + placeOfResidence
                                +", Total Tuition: " + tuition + "0";
    }
}
