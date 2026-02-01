package repositories;

import database.IDB;
import entities.ParkingSpot;

import java.sql.*;

public class ParkingSpotRepository {

    private final IDB db;

    public ParkingSpotRepository(IDB db) {
        this.db = db;
    }

    // ✅ Бос spot табу
    public ParkingSpot findFreeSpot() throws SQLException {
        String sql = "SELECT * FROM parking_spots WHERE available = TRUE LIMIT 1";
        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Spot объектісіне id, type, isFree дұрыс set болу керек
                return new ParkingSpot(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getBoolean("available")
                );
            }
        }
        return null; // ешқандай бос spot жоқ
    }

    // Spot-ты бос емес деп белгілеу
    public void updateAvailability(int spotId, boolean isFree) throws SQLException {
        String sql = "UPDATE parking_spots SET available  = ? WHERE id = ?";
        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setBoolean(1, isFree);
            stmt.setInt(2, spotId);
            stmt.executeUpdate();
        }
    }
}
