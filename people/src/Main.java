import sun.security.util.ByteArrayLexOrder;

import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();

        Person p = new Person("Kyle", " 21 ", " Software Dev");
        Person p2 = new Person("Adam", " 21 ", " CEO");

        people.add(p);
        people.add(p2);

        // loop through person arraylist
        for(Person pers : people) {
               // System.out.println(pers);
                if(pers.name == "Kyle") {
                        System.out.println(pers);
                }
        }



    }

    // search through the person object by name



}
