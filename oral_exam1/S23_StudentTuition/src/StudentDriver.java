/**
 * Main driver class for this assignment. All it does is create a new student of all 18 types, print their info to the
 * screen, change the tuition rate, and reprint them to the screen
 */
public class StudentDriver {
    public static void main(String[] args) {
        //Instantiate all the students
        Student student1 = new EngineeringIowa("John","Doe","111111111",10,"Graduate");
        Student student2 = new LiberalArtsIowa("Jane","Yane","222222222",13,"Graduate");
        Student student3 = new EngineeringIowa("Debrah","Redya","3333333",16,"Undergraduate");
        Student student4 = new LiberalArtsIowa("Jonny","Fonzy","44444444",15,StudentStatus.UNDERGRADUATE);
        Student student5 = new EngineeringIowa("Lane","Frame","5555555",5,"Open Enrolled");
        Student student6 = new LiberalArtsIowa("Ryan","Spyin","6666666",15,StudentStatus.OPENENROLLED);
        Student student7 = new EngineeringOOS("Ron","Con","777777777",8,"Graduate");
        Student student8 = new LiberalArtsOOS("Dean","Bean","888888",4,"Graduate");
        Student student9 = new EngineeringOOS("AJ","ShmayWay","11221133",11,"Undergraduate");
        Student student10 = new LiberalArtsOOS("Alex","Shamlex","11221144",19,StudentStatus.UNDERGRADUATE);
        Student student11 = new EngineeringOOS("Seth","Rest","11221133",6,"Open Enrolled");
        Student student12 = new LiberalArtsOOS("Olivia","Sholivia","11221144",1,StudentStatus.OPENENROLLED);
        Student student13 = new LiberalArtsForeign("Ann","Ran","11221144",12,"Graduate");
        Student student14 = new EngineeringForeign("Reed","Lead","11221133",14,"Undergraduate");
        Student student15 = new LiberalArtsForeign("Paul","Small","11221144",15,StudentStatus.UNDERGRADUATE);
        Student student16 = new EngineeringForeign("Kyser","Shmizer","11221133",3,"Open Enrolled");
        Student student17 = new LiberalArtsForeign("Blessed","Messed","11221144",8,StudentStatus.OPENENROLLED);
        Student student18 = new EngineeringForeign("Xi","Doe","11221133",11,"Graduate");

        //Print students
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());
        System.out.println(student5.toString());
        System.out.println(student6.toString());
        System.out.println(student7.toString());
        System.out.println(student8.toString());
        System.out.println(student9.toString());
        System.out.println(student10.toString());
        System.out.println(student11.toString());
        System.out.println(student12.toString());
        System.out.println(student13.toString());
        System.out.println(student14.toString());
        System.out.println(student15.toString());
        System.out.println(student16.toString());
        System.out.println(student17.toString());
        System.out.println(student18.toString()+"\n\n");

        //Change all tuition rates
        student1.setBaseClassHourTuitionRate(200);
        student2.setBaseClassHourTuitionRate(200);
        student3.setBaseClassHourTuitionRate(200);
        student4.setBaseClassHourTuitionRate(200);
        student5.setBaseClassHourTuitionRate(200);
        student6.setBaseClassHourTuitionRate(200);
        student7.setBaseClassHourTuitionRate(200);
        student8.setBaseClassHourTuitionRate(200);
        student9.setBaseClassHourTuitionRate(200);
        student10.setBaseClassHourTuitionRate(200);
        student11.setBaseClassHourTuitionRate(200);
        student12.setBaseClassHourTuitionRate(200);
        student13.setBaseClassHourTuitionRate(200);
        student14.setBaseClassHourTuitionRate(200);
        student15.setBaseClassHourTuitionRate(200);
        student16.setBaseClassHourTuitionRate(200);
        student17.setBaseClassHourTuitionRate(200);
        student18.setBaseClassHourTuitionRate(200);

        //Print students
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());
        System.out.println(student5.toString());
        System.out.println(student6.toString());
        System.out.println(student7.toString());
        System.out.println(student8.toString());
        System.out.println(student9.toString());
        System.out.println(student10.toString());
        System.out.println(student11.toString());
        System.out.println(student12.toString());
        System.out.println(student13.toString());
        System.out.println(student14.toString());
        System.out.println(student15.toString());
        System.out.println(student16.toString());
        System.out.println(student17.toString());
        System.out.println(student18.toString());

    }
}
