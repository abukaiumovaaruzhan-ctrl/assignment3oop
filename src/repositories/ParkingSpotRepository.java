package repositories;

import database.IDB;
import entities.ParkingSpot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ParkingSpotRepository {

    private final IDB db;

    public ParkingSpotRepository(IDB db) {
        this.db = db;
    }

    public ParkingSpot findFreeSpot() {
        try (Connection con = db.getConnection();
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM parking_spots WHERE available = true LIMIT 1");

            if (rs.next()) {
                return new ParkingSpot(rs.getInt("id"), true);
            }
            return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAvailability(int id, boolean available) {
        try (Connection con = db.getConnection();
             Statement st = con.createStatement()) {

            st.executeUpdate(
                    "UPDATE parking_spots SET AVAILABLE=" + available + " WHERE id=" + id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
