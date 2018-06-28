public class Rental {

    Person p;
    Items i;
    int days;

    public Rental(Person p, Items i, int days) {
        this.p = p;
        this.i = i;
        this.days = days;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Items getI() {
        return i;
    }

    public void setI(Items i) {
        this.i = i;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
