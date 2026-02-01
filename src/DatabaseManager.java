public class DatabaseManager {

    private static DatabaseManager instance;

    private DatabaseManager() {
        System.out.println("Database connected");
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }
}
