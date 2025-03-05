package base;
import java.util.ArrayList;
import java.util.UUID;
public class Person {
    public int personID;
    public String nationalID;
    public String name;
    public static ArrayList<Person> personList = new ArrayList<Person>();

    public Person(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;
        personList.add(this);
        this.personID = personList.size();
    }

    public static Person findByID(int personID){
        for (Person person : personList){
            if (person.personID == personID){
                return person;
            }
        }
        return null;
    }
}