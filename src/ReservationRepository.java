package repositories;

import database.IDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ReservationRepository {

    private final IDB db;

    public ReservationRepository(IDB db) {
        this.db = db;
    }

    public void create(int vehicleId, int spotId, int tariffId) {
        String sql = "INSERT INTO reservations(vehicle_id, spot_id, start_time, tariff_id) VALUES (?, ?, ?, ?)";

        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, vehicleId);
            ps.setInt(2, spotId);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(4, tariffId);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}