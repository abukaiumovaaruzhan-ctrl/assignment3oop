package services;

import entities.Tariff;

import java.time.Duration;
import java.time.LocalDateTime;

public class PricingService {

    public double calculate(LocalDateTime start, LocalDateTime end, Tariff tariff) {
        long hours = Duration.between(start, end).toHours();
        if (hours == 0) hours = 1;
        return hours * tariff.getPricePerHour();
    }
}
