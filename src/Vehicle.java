package entities;

public class Vehicle {
    private int id;
    private String plate;

    public Vehicle(int id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    public int getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }
}
