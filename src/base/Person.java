package base;
import java.util.ArrayList;
import java.util.UUID;
public class Person {
    public int Uid;
    public String nationalID;
    public String name;
    public static ArrayList<Person> personList = new ArrayList<Person>();

    public Person(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;
        this.Uid = generateIntUUID();
        personList.add(this);
    }

    public static Person findByID(int personID){
        for (Person person : personList){
            if (person.Uid == personID){
                return person;
            }
        }
        return null;
    }
    private int generateIntUUID() {
        return Math.abs(UUID.randomUUID().hashCode());
    }

}