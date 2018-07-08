public class Rental {

    Person person;
    Item item;
    int days;

    public Rental(Person person, Item item, int days) {
        this.person = person;
        this.item = item;
        this.days = days;
    }

    public Person getP() {
        return this.person;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getDays() {
        return this.days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String toString() {
        return "Person: " + this.person.getName() + "Item name: " + this.item.getItem_name() + "Days: " + this.getDays();
    }
}
