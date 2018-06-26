public class Motorcycle extends Vehicle {

    private int chair;

    Motorcycle(String engine, int wheels, int seat, String colour, int chair) {
        super(engine, wheels, seat, colour);
        this.chair = chair;
    }

    public String toString() {
        return "Chair: " + chair;
    }

}
