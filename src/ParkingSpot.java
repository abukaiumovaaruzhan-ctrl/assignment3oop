package entities;

public class ParkingSpot {
    private int id;
    private String type; // "Regular" немесе "Electric"
    private boolean available; // бұрын isFree еді

    // Толық конструктор
    public ParkingSpot(int id, String type, boolean available) {
        this.id = id;
        this.type = type;
        this.available = available;
    }

    // Қысқа конструктор қажет болса
    public ParkingSpot(int id, boolean available) {
        this.id = id;
        this.type = "Regular"; // default
        this.available = available;
    }


    public int getId() { return id; }
    public String getType() { return type; }


    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
