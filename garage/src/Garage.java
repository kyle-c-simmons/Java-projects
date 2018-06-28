import java.lang.reflect.Array;
import java.util.ArrayList;

public class Garage {

    ArrayList<Vehicle> inGarage = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        inGarage.add(v);
    }

    public void emptyGarage(Vehicle v) {
        inGarage.remove(v);
    }

    public void calculateBill() {
        for(Vehicle vehicleList: inGarage) {
            //System.out.println(vehicleList);

            if(vehicleList instanceof Car) {
                ((Car) vehicleList).steeringWheel = "20";
            }
            else if(vehicleList instanceof Motorcycle) {
                ((Motorcycle) vehicleList).chair = 40;
            }
        }

    }
}

