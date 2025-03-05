package uni;

import java.util.ArrayList;

public class Student {
    public int Uid;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentID;

    public Student(int personID, int entranceYear, int majorID) {
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        this.personID = personID;

        if (Major.findById(majorID) != null) {
            Major.findById(majorID).addStudent();
        } else {
            System.out.println("Major not found");
        }
        setStudentID();

        studentList.add(this);
        this.Uid = studentList.size();
    }

    public static Student findById(int ID) {
        for (Student student : studentList) {
            if (student.Uid == ID) {
                return student;
            }
        }
        return null;
    }
    public void setStudentID(){
        Major major = Major.findById(majorID);
        String temp = String.valueOf(entranceYear);
        if(major == null){
            System.out.println("Major not found");
            this.studentID = "Faulty major selection";
        }else {
            int num = major.numberOfStudents + 1;
            if (majorID < 10){
                temp += "0";
            }
            temp += String.valueOf(majorID);
            temp += String.valueOf(num);
            this.studentID = temp;
        }
    }
}

