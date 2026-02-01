package repositories;

import entities.Vehicle;
import database.IDB;
import java.sql.*;
import java.util.Arrays;
import java.util.Optional;

public class VehicleRepository {
    private final IDB db;

    public VehicleRepository(IDB db) { this.db = db; }

    public int save(Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO vehicles (plate, model, owner_name) VALUES (?, ?, ?) RETURNING id";
        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setString(1, vehicle.getPlate());
            stmt.setString(2, vehicle.getModel());
            stmt.setString(3, vehicle.getOwnerName());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                vehicle.setId(id); // ID set
                return id;
            }
        }
        return -1;
    }

    public Optional<Vehicle> findByPlate(String plate) throws SQLException {
        String sql = "SELECT * FROM vehicles WHERE plate = ?";
        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setString(1, plate);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Vehicle v = new Vehicle(rs.getString("plate"), rs.getString("model"), rs.getString("owner_name"));
                v.setId(rs.getInt("id"));
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }

    public Arrays findAll() {
        return null;
    }
}
