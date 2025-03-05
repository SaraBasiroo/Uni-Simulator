import base.Person;
import uni.*;

public class Main {
    public static void main(String[] args) {
        Major CS = new Major("Computer Science", 15);
        Major AM = new Major("Applied Mathematics", 10);
        Person arman = new Person("Arman", "1111111111");
        Person pedram = new Person("Pedram", "2222222222");
        Person mahdi = new Person("Mahdi", "3333333333");
        Person ali = new Person("Ali", "4444444444");
        Person sania = new Person("Sania", "5555555555");
        arman.personID = 1;
        pedram.personID = 2;
        mahdi.personID = 3;
        ali.personID = 4;
        sania.personID = 5;
        Student student1 = new Student(1,400,CS.majorUiD);
        Student student2 = new Student(2,401,CS.majorUiD);
        Student student3 = new Student(3,402,AM.majorUiD);
        System.out.println("Students:");
        for (Student s : Student.studentList) {
            System.out.println(Person.findByID(s.Uid).name + ": " + s.studentID);
        }
        System.out.println("-----------------------------------------");

        Professor professor1 = new Professor(4, CS.majorUiD);
        Professor professor2 = new Professor(5, AM.majorUiD);
        System.out.println("Professors and their IDs:");
        int counter = 0;
        for (int i = 4; i <= 5; i++) {
            if (Person.findByID(i) != null) {
                System.out.println(Person.findByID(i).name);
                System.out.println(Professor.professorList.get(counter).professorID);
                counter++;
            }
            else {
                System.out.println("No professor found this ID : " + i);
            }
        }
        System.out.println("-----------------------------------------");

        Course course1 = new Course("Basic Programming", 3);
        Course course2 = new Course("Algorithms", 3);
        Course course3 = new Course("Linear Algebra", 2);
        PresentedCourse presentedCourse1 = new PresentedCourse(course1.courseID, professor1.professorID, 30);
        PresentedCourse presentedCourse2 = new PresentedCourse(course2.courseID, professor1.professorID, 35);
        PresentedCourse presentedCourse3 = new PresentedCourse(course3.courseID, professor2.professorID, 33);
        presentedCourse1.addStudent(student1.Uid);
        presentedCourse1.addStudent(student2.Uid);
        presentedCourse2.addStudent(student1.Uid);
        presentedCourse2.addStudent(student2.Uid);
        presentedCourse2.addStudent(student3.Uid);
        presentedCourse3.addStudent(student3.Uid);

        Transcript transcript1 = new Transcript(student1.Uid);
        Transcript transcript2 = new Transcript(student2.Uid);
        Transcript transcript3 = new Transcript(student3.Uid);

        transcript1.setGrade(presentedCourse1.presentedCourseID, 20);
        transcript1.setGrade(presentedCourse2.presentedCourseID, 15);
        transcript2.setGrade(presentedCourse1.presentedCourseID, 17.5);
        transcript2.setGrade(presentedCourse2.presentedCourseID, 11);
        transcript3.setGrade(presentedCourse2.presentedCourseID, 17);
        transcript3.setGrade(presentedCourse3.presentedCourseID, 9);

        System.out.println(Person.findByID(student1.personID).name + "'s transcript:");
        transcript1.printTranscript();
        System.out.println("*****************************************");
        System.out.println(Person.findByID(student2.personID).name + "'s transcript:");
        transcript2.printTranscript();
        System.out.println("*****************************************");
        System.out.println(Person.findByID(student3.personID).name + "'s transcript:");
        transcript3.printTranscript();
        System.out.println("-----------------------------------------");
        if (Person.findByID(student1.personID) != null) {
            System.out.println(Person.findByID(student1.personID).name + " GPA:");
            System.out.println(transcript1.getGPA());
        }
        else {
            System.out.println("No student found with ID " + student1.personID);
        }
        if (Person.findByID(student2.personID) != null) {
            System.out.println(Person.findByID(student2.personID).name + " GPA:");
            System.out.println(transcript2.getGPA());
        }
        else {
            System.out.println("No student found with ID " + student2.personID);
        }
        if (Person.findByID(student3.personID) != null) {
            System.out.println(Person.findByID(student3.personID).name + " GPA:");
            System.out.println(transcript3.getGPA());
        }
        else {
            System.out.println("No student found with this ID " + student3.personID);
        }
    }
}