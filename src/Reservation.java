package entities;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private int vehicleId;
    private int spotId;
    private int tariffId;

    public Reservation(Builder builder) {
        this.vehicleId = builder.vehicleId;
        this.spotId = builder.spotId;
        this.tariffId = builder.tariffId;
    }

    public Reservation(int vehicleId, int spotId, LocalDateTime start, LocalDateTime end) {
    }

    public int getVehicleId() { return vehicleId; }
    public int getSpotId() { return spotId; }
    public int getTariffId() { return tariffId; }

    public static class Builder {
        private int vehicleId;
        private int spotId;
        private int tariffId;

        public Builder vehicleId(int vehicleId) { this.vehicleId = vehicleId; return this; }
        public Builder spotId(int spotId) { this.spotId = spotId; return this; }
        public Builder tariffId(int tariffId) { this.tariffId = tariffId; return this; }
        public Reservation build() { return new Reservation(this); }
    }
}
