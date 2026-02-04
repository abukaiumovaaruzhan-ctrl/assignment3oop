package services;

import entities.ParkingSpot;
import entities.Vehicle;
import exceptions.NoFreeSpotsException;
import exceptions.InvalidPlateException;
import repositories.ParkingSpotRepository;
import repositories.ReservationRepository;
import repositories.VehicleRepository;

import java.sql.SQLException;

public class ReservationService {

    private final ParkingSpotRepository spotRepo;
    private final ReservationRepository reservationRepo;
    private final VehicleRepository vehicleRepo;

    public ReservationService(ParkingSpotRepository spotRepo,
                              ReservationRepository reservationRepo,
                              VehicleRepository vehicleRepo) {
        this.spotRepo = spotRepo;
        this.reservationRepo = reservationRepo;
        this.vehicleRepo = vehicleRepo;
    }

    public void reserve(String plate) throws SQLException {

       
        if (plate == null || plate.length() < 3) {
            throw new InvalidPlateException();
        }

        
        Vehicle vehicle = vehicleRepo.findByPlate(plate)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

      
        ParkingSpot spot = spotRepo.findFreeSpot();
        if (spot == null) {
            throw new NoFreeSpotsException();
        }

        int tariffId = 1;

        
        reservationRepo.create(vehicle.getId(), spot.getId(), tariffId);


        
        spotRepo.updateAvailability(spot.getId(), false);

        System.out.println("Spot reserved successfully");
    }
}
