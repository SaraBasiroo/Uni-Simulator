package uni;

import java.util.ArrayList;
public class PresentedCourse {
    public int presentedCourseID;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<PresentedCourse>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIDs = new ArrayList<Integer>();

    public PresentedCourse(int courseID, int professorID, int capacity) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = capacity;
        presentedCourseList.add(this);
        presentedCourseID = presentedCourseList.size();
    }
    public static PresentedCourse findByID(int presentedCourseID) {
        for (PresentedCourse pCourse : presentedCourseList) {
            if (pCourse.presentedCourseID == presentedCourseID) {
                return pCourse;
            }
        }
        return null;
    }
    public void addStudent(int studentID) {
        if (!studentIDs.contains(studentID)) {
            if (studentIDs.size() < capacity) {
                studentIDs.add(studentID);
            }
            else {
                System.out.println("Maximum capacity reached. Can't add new students.");
            }
        }
        else {
            System.out.println("Student ID already added.");
        }
    }
}
