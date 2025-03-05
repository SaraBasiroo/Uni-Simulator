package uni;

import java.util.ArrayList;

public class Major {
    public int majorUiD;
    public String name;
    public final int capacity;
    public int numberOfStudents = 0;
    public static ArrayList<Major> majorList = new ArrayList<Major>();
    public Major(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        majorList.add(this);
        this.majorUiD = majorList.size();
    }
    public static Major findById(int UiD) {
        for (Major major :majorList){
            if (major.majorUiD == UiD){
                return major;
            }
        }
        return null;
    }
    public void addStudent(){
        if (numberOfStudents < capacity){
            numberOfStudents++;
        }else {
            System.out.println("Maximum capacity reached. Can't add any more students to this major");
        }
    }
}
