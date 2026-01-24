package entities;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private int vehicleId;
    private int spotId;
    private LocalDateTime start;
    private LocalDateTime end;

    public Reservation(int id, int vehicleId, int spotId,
                       LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.spotId = spotId;
        this.start = start;
        this.end = end;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getSpotId() {
        return spotId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
