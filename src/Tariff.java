package entities;

public class Tariff {
    private double pricePerHour;

    public Tariff(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}
