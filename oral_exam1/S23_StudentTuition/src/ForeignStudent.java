/**
 * Created by Tanner on 9/27/2016.
 */
public class ForeignStudent extends Student {
        public ForeignStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, StudentStatus studentStatus, CollegeEnrolled collegeEnrolled) {
            super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
        }

        public ForeignStudent(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String studentStatus, String collegeEnrolled) {
            super(firstName, lastName, studentID, numberOfRegisteredHours, studentStatus, collegeEnrolled);
        }


        @Override
        public double GenerateTuition()
        {
            placeOfResidence ="FOREIGN";
            if(numberOfRegisteredHours<= studentStatus.getFullLoad())
            {
                totalTuition = (.65*numberOfRegisteredHours*baseClassHourTuitionRate);
                if (numberOfRegisteredHours >= collegeEnrolled.getHours()) {
                    totalTuition = totalTuition+collegeEnrolled.getFees();
                }
            }
            else
            {
                totalTuition = ((1.03*(studentStatus.getFullLoad()*baseClassHourTuitionRate))+
                        (((numberOfRegisteredHours-studentStatus.getFullLoad())*baseClassHourTuitionRate)));
                totalTuition =totalTuition+collegeEnrolled.getFees();
            }
            return totalTuition;
        }

    }
