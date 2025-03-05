package uni;

import java.util.HashMap;

public class Transcript {

    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();

    public Transcript(int studentID) {
        this.studentID = studentID;
    }
    public void setGrade(int presentedCourseID, double grade) {
        boolean exists = false;
        if (PresentedCourse.findByID(presentedCourseID) != null) {
            exists = PresentedCourse.findByID(presentedCourseID).studentIDs.contains(this.studentID);
        }
        else {
            System.out.println("Course with id :" + presentedCourseID + " does not exist");
        }
        if (exists) {
            transcript.put(presentedCourseID, grade);
        }
        else {
            System.out.println("Student with id:" + studentID + " does not have this course");
        }
    }
    public double getGPA(){
        int numberOfUnits = 0;
        double divided=0;
        for (Integer i : transcript.keySet()) {
            if (Course.findById(PresentedCourse.findByID(i).courseID) != null){
                numberOfUnits += Course.findById(PresentedCourse.findByID(i).courseID).units;
                divided += Course.findById(PresentedCourse.findByID(i).courseID).units * transcript.get(i);
            }
            else {
                System.out.println("Course with id :" + PresentedCourse.findByID(i).courseID + " does not exist");
            }
        }
        return divided/numberOfUnits;
    }
    public void printTranscript() {
        for (Integer i : transcript.keySet()) {
            if (Course.findById(PresentedCourse.findByID(i).courseID) != null) {
                String name = Course.findById(PresentedCourse.findByID(i).courseID).title;
                double grade = transcript.get(i);
                System.out.println(name + " : " + grade);
            }
            else {
                System.out.println("Course with id :" + PresentedCourse.findByID(i).courseID + " does not exist");
            }

        }
    }
}
