/**
 * Created by Tanner on 9/27/2016.
 */
public class StudentDriver {
    public static void main(String[] args) {
        Student student1 = new IowaStudent("John","Doe","111111111",10,"Graduate","Engineering");
        Student student2 = new IowaStudent("Jane","Yane","222222222",13,"Graduate","Liberal Arts");
        Student student3 = new IowaStudent("Debrah","Redya","3333333",16,"Undergraduate","Engineering");
        Student student4 = new IowaStudent("Jonny","Fonzy","44444444",15,StudentStatus.UNDERGRADUATE,CollegeEnrolled.LIBERALARTS);
        Student student5 = new IowaStudent("Lane","Frame","5555555",5,"Open Enrolled","Engineering");
        Student student6 = new IowaStudent("Ryan","Spyin","6666666",15,StudentStatus.OPENENROLLED,CollegeEnrolled.LIBERALARTS);
        Student student7 = new OOSStudent("Ron","Con","777777777",8,"Graduate","Engineering");
        Student student8 = new OOSStudent("Dean","Bean","888888",4,"Graduate","Liberal Arts");
        Student student9 = new OOSStudent("AJ","ShmayWay","11221133",11,"Undergraduate","Engineering");
        Student student10 = new OOSStudent("Alex","Shamlex","11221144",19,StudentStatus.UNDERGRADUATE,CollegeEnrolled.LIBERALARTS);
        Student student11 = new OOSStudent("Seth","Rest","11221133",6,"Open Enrolled","Engineering");
        Student student12 = new OOSStudent("Olivia","Sholivia","11221144",1,StudentStatus.OPENENROLLED,CollegeEnrolled.LIBERALARTS);
        Student student13 = new ForeignStudent("Ann","Ran","11221144",12,"Graduate","Liberal Arts");
        Student student14 = new ForeignStudent("Reed","Lead","11221133",14,"Undergraduate","Engineering");
        Student student15 = new ForeignStudent("Paul","Small","11221144",15,StudentStatus.UNDERGRADUATE,CollegeEnrolled.LIBERALARTS);
        Student student16 = new ForeignStudent("Kyser","Shmizer","11221133",3,"Open Enrolled","Engineering");
        Student student17 = new ForeignStudent("Blessed","Messed","11221144",8,StudentStatus.OPENENROLLED,CollegeEnrolled.LIBERALARTS);
        Student student18 = new ForeignStudent("Xi","Doe","11221133",11,"Graduate","Engineering");

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
