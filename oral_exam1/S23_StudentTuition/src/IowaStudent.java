/**
 * Created by Tanner on 9/27/2016.
 */
public class IowaStudent extends Student {
    public IowaStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, StudentStatus studentStatus, CollegeEnrolled collegeEnrolled) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
    }

    public IowaStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String studentStatus, String collegeEnrolled) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
    }

    @Override
    public double GenerateTuition()
    {
        placeOfResidence ="IOWA";
        if(numberOfRegisteredHours<= studentStatus.getFullLoad())
        {
            totalTuition = (.65*numberOfRegisteredHours*baseClassHourTuitionRate);
            if (numberOfRegisteredHours >= collegeEnrolled.getHours()) {
                totalTuition = totalTuition+collegeEnrolled.getFees();
            }
        }
        else
        {
            totalTuition = ((.65*(studentStatus.getFullLoad()*baseClassHourTuitionRate))+
                    (.9*((numberOfRegisteredHours-studentStatus.getFullLoad())*baseClassHourTuitionRate)));
            totalTuition =totalTuition+collegeEnrolled.getFees();
        }
        return totalTuition;
    }

}
