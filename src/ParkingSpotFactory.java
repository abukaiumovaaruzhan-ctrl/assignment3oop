import entities.ElectricParkingSpot;
import entities.RegularParkingSpot;
import entities.ParkingSpotType;

public class ParkingSpotFactory {

    public static ParkingSpotType create(String type) {
        if (type.equalsIgnoreCase("electric")) {
            return new ElectricParkingSpot();
        } else {
            return new RegularParkingSpot();
        }
    }
}
