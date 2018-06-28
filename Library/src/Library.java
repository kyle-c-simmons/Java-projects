import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library implements checkout {

    private String name;
    private int monthlyMembership;
    private String location;

    ArrayList<Person> person = new ArrayList<>();
    ArrayList<Items> items = new ArrayList<>();
    ArrayList<Rental> rental = new ArrayList<>();

    public Library(String name, int monthlyMembership, String location) {
        this.name = name;
        this.monthlyMembership = monthlyMembership;
        this.location = location;
    }

    public Library(String name, int monthlyMembership) {
        this.name = name;
        this.monthlyMembership = monthlyMembership;
    }

    // Uses the checkout interface
    @Override
    public void checkoutItem() {

    }

    @Override
    public void checkinItem() {

    }

    @Override
    public void addItem(Items i) {
        items.add(i);

    }

    @Override
    public void removeItem(String name) {
        for(Items i: items) {
            if(i.getItem_name().equals(name)) {
                items.remove(i);
            }
        }
    }

    @Override
    public void updateItem() {

    }



    

}
