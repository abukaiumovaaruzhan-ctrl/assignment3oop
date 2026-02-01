package entities;

public class Vehicle {
    private int id;
    private String plate;
    private String model;
    private String ownerName;

    public Vehicle(String plate, String model, String ownerName) {
        this.plate = plate;
        this.model = model;
        this.ownerName = ownerName;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPlate() { return plate; }
    public String getModel() { return model; }
    public String getOwnerName() { return ownerName; }
}
