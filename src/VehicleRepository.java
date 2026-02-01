import entities.Vehicle;

import java.util.*;

public class VehicleRepository implements Repository<entities.Vehicle> {

    private final Map<Integer, Vehicle> storage = new HashMap<>();

    @Override
    public void save(Vehicle vehicle) {
        storage.put(vehicle.getId(), vehicle);
    }

    @Override
    public void save(Vehicle entity) {

    }

    @Override
    public Optional<Vehicle> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Vehicle> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }
}
