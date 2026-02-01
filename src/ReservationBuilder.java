import java.time.LocalDateTime;

public class ReservationBuilder {

    private int vehicleId;
    private int spotId;
    private LocalDateTime start;
    private LocalDateTime end;

    public ReservationBuilder vehicleId(int id) {
        this.vehicleId = id;
        return this;
    }

    public ReservationBuilder spotId(int id) {
        this.spotId = id;
        return this;
    }

    public ReservationBuilder start(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public ReservationBuilder end(LocalDateTime end) {
        this.end = end;
        return this;
    }

    public entities.Reservation build() {
        return new entities.Reservation(vehicleId, spotId, start, end);
    }
}
