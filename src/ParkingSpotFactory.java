public class ParkingSpotFactory {

    public static entities.VipParkingSpot createSpot(String type, int id) {
        if (type.equals("VIP")) {
            return new entities.VipParkingSpot(id);
        } else if (type.equals("ELECTRIC")) {
            return new ElectricParkingSpot(id);
        }
        return new RegularParkingSpot(id);
    }
}
