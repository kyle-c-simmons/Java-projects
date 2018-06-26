import java.util.ArrayList;

public class Person {

    public String name;
    public String age;
    public String jobTitle;


    Person(String name, String age, String jobTitle) {
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
    }

    public String toString() {

        return "Name is: " + this.name + "Age is: " + this.age + "Job title" + this.jobTitle;

    }






}
