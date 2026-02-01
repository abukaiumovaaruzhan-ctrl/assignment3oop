import entities.Vehicle;
import repositories.VehicleRepository;

import java.util.function.Predicate;

public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public boolean filter(Predicate<Vehicle> condition) {
        return repository.findAll()
                .getClass()
                .isInterface();


    }

}
