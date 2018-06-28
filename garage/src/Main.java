import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        // Create objects for cars / motorcycles
        Car mustang = new Car("v8", 4, 3, "yellow", "black");
        Car focus = new Car("v8", 4, 5, "blue", "green");
        Car bmw = new Car("v8", 4, 5, "blue", "black");

        Motorcycle m1 = new Motorcycle("v8", 2, 1, "green",1);
        Motorcycle m2 = new Motorcycle("v8", 2, 1, "silver", 1);

        // add vehicles to vehicles array
        vehicles.add(mustang);
        vehicles.add(focus);
        vehicles.add(bmw);
        vehicles.add(m1);
        vehicles.add(m2);

        // setup garage
        Garage garage = new Garage();

        // add vehicles to garage
        garage.addVehicle(mustang);
        garage.addVehicle(focus);
        garage.addVehicle(bmw);
        garage.addVehicle(m1);
        garage.addVehicle(m2);

        System.out.println(garage.inGarage);


    }

}
