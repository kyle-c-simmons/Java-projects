public class Vehicle {

    // Setup Vehicle attributes
    private String engine;
    public int wheels;
    private int seat;
    private String colour;

    Vehicle(String engine, int wheels, int seat, String colour) {
        this.engine = engine;
        this.wheels = wheels;
        this.seat = seat;
        this.colour = colour;
    }

    public String toString() {
        return "Engine: " + this.engine + "Wheels: " + this.wheels + "Seat: " + this.seat + "Colours: " + this.colour;
    }


}
