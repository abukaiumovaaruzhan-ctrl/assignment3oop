import database.IDB;
import database.PostgresDB;
import entities.Vehicle;
import repositories.ParkingSpotRepository;
import repositories.ReservationRepository;
import repositories.VehicleRepository;
import services.ReservationService;

import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        PostgresDB db = new PostgresDB();

        ParkingSpotRepository spotRepo = new ParkingSpotRepository(db);
        ReservationRepository reservationRepo = new ReservationRepository(db);
        VehicleRepository vehicleRepo = new VehicleRepository(db);

        ReservationService service =
                new ReservationService(spotRepo, reservationRepo, vehicleRepo);

        try {
            // ✅ Vehicle алдын-ала қосу немесе DB-дан алу
            Vehicle vehicle;
            Optional<Vehicle> existing = vehicleRepo.findByPlate("123ABC");
            if (existing.isPresent()) {
                vehicle = existing.get();
            } else {
                vehicle = new Vehicle("123ABC", "Toyota Camry", "Aruzhan");
                vehicleRepo.save(vehicle);
            }

            // ✅ Reservation жасау
            service.reserve(vehicle.getPlate());

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
