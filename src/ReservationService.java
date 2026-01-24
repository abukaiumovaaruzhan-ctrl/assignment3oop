package services;

import entities.ParkingSpot;
import exceptions.NoFreeSpotsException;
import exceptions.InvalidPlateException;
import repositories.ParkingSpotRepository;
import repositories.ReservationRepository;

public class ReservationService {

    private final ParkingSpotRepository spotRepo;
    private final ReservationRepository reservationRepo;

    public ReservationService(ParkingSpotRepository spotRepo,
                              ReservationRepository reservationRepo) {
        this.spotRepo = spotRepo;
        this.reservationRepo = reservationRepo;
    }

    public void reserve(String plate) {

        if (plate == null || plate.length() < 3) {
            throw new InvalidPlateException();
        }

        ParkingSpot spot = spotRepo.findFreeSpot();
        if (spot == null) {
            throw new NoFreeSpotsException();
        }

        int tariffId = 1 ;
        int vehicleId=1 ;
        reservationRepo.create(vehicleId, spot.getId(), tariffId);
        spotRepo.updateAvailability(spot.getId(), false);

        System.out.println("Spot reserved successfully");
    }
}
