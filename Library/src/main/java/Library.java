import java.util.ArrayList;

public class Library implements checkout {

    private String name;
    private int monthlyMembership;
    private String location;

    private ArrayList<Person> person = new ArrayList<>();
   private ArrayList<Item> items = new ArrayList<>();
   private ArrayList<Rental> rental = new ArrayList<>();

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
    public void checkoutItem(Person p, Item i, int days) {
        Rental r = new Rental(p, i, days);
        rental.add(r);
    }

    @Override
    public void checkinItem() {
        for(Rental r: rental) {
            rental.remove(r);
        }
    }

    @Override
    public void addItem(Item i) {
        items.add(i);

    }

    @Override
    public void removeItem(String name) {
        for(Item i: items) {
            if(i.getItem_name().equals(name)) {
                items.remove(i);
            }
        }
    }

    @Override
    public void updateItem(String name) {
        for(Item i: items) {
            i.setItem_name(name);
        }
    }

    public ArrayList<Rental> getRentals() {
        return this.rental;
    }

    public void addRental(Rental r) {

       this.rental.add(r);
    }





}
