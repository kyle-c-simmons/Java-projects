import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Rental> rental = new ArrayList<>();

        // Library
        Library libraryManchester = new Library("Library", 12, "Manchester");
        Library libraryLondon = new Library("Library", 15, "London");

        // Create new people
        Person david_obj = new Person("Daivd", 90, "IT");
        Person james_obj = new Person("James", 60, "IT");
        Person adam_obj = new Person("Adam", 30, "Teacher");

        // Items
        Book goodBook_obj = new Book(1, "Good Book");
        Book badBook_obj = new Book(2, "Bad Book");

        Newspaper daily_obj = new Newspaper(3, "Daily", "bob");
        Newspaper bbc_obj = new Newspaper(4, "BBC", "bob");

        Dissertation goodGrades_obj = new Dissertation(5, "Programming", 90);
        Dissertation badGrades_obj = new Dissertation(6, "Programming", 30);

        // Add the items to the london library
        libraryLondon.addItem(daily_obj);
        libraryLondon.addItem(goodBook_obj);

        // Checkout the items from the library
        libraryLondon.checkoutItem(david_obj, daily_obj, 12);
        libraryLondon.checkoutItem(david_obj, goodBook_obj, 12);


        Rental rent1 = new Rental(david_obj, daily_obj, 12);

        libraryLondon.addRental(rent1);



        // Display current rentals
        //System.out.println(libraryLondon.getRentals());

        for (Rental r : libraryLondon.getRentals()){
            System.out.println(r.toString());
        }







    }

}
