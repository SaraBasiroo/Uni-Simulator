package uni;

import java.util.ArrayList;
public class Course {
    public int courseID;
    public String title;
    public static ArrayList<Course> courseList = new ArrayList<Course>();
    public int units;

    public Course(String title, int units) {
        this.title = title;
        this.units = units;
        courseList.add(this);
        this.courseID = courseList.size();
    }
    public static Course findById(int id) {
        for (Course course : courseList) {
            if (course.courseID == id) {
                return course;
            }
        }
        return null;
    }
}
