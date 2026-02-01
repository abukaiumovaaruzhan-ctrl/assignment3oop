import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<Vehicle> filter(Predicate<Vehicle> condition) {
        return repository.findAll()
                .stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
}
