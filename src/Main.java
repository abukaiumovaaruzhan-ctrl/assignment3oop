import database.IDB;
import database.PostgresDB;
import repositories.ParkingSpotRepository;
import repositories.ReservationRepository;
import services.ReservationService;

public class Main {
    public static void main(String[] args) {

        PostgresDB db = new PostgresDB();

        ParkingSpotRepository spotRepo = new ParkingSpotRepository((IDB) db);
        ReservationRepository reservationRepo = new ReservationRepository((IDB) db);

        ReservationService service =
                new ReservationService(spotRepo, reservationRepo);

        try {
            service.reserve("123ABC");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
