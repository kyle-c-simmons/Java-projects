public class Car extends Vehicle {

    private String steeringWheel;

    Car(String engine, int wheels, int seat, String colour, String steeringWheel) {
        super(engine, wheels, seat, colour);
        this.steeringWheel = steeringWheel;
    }

    public String toString() {
        return "Steering Wheel: " + this.steeringWheel;
    }

}
