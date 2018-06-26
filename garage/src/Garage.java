import java.lang.reflect.Array;
import java.util.ArrayList;

public class Garage {

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    Car mustang = new Car("v8", 4, 3, "yellow", "black");
    Car focus = new Car("v8", 4, 5, "blue", "black");
    Car bmw = new Car("v8", 4, 5, "blue", "black");

    Motorcycle m1 = new Motorcycle("v8", 2, 1, "green",1);
    Motorcycle m2 = new Motorcycle("v8", 2, 1, "silver", 1);

    // Display cars/motorcycles  objects
    public void displayVehicles() {

        vehicles.add(mustang);
        vehicles.add(focus);
        vehicles.add(bmw);
        vehicles.add(m1);
        vehicles.add(m2);

        for(Vehicle vehicleList: vehicles) {
        System.out.println(vehicleList);
    }
}





    // Create method remove vehicle

    // Fix Vehicle method

    // Empty garage

}
