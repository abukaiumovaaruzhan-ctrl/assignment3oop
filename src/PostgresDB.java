package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresDB implements database.IDB {

    private static final String URL =
            "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres?sslmode=require";

    private static final String USER = "postgres.mqwdhrlarceybhkdfved";
    private static final String PASSWORD = "aruzhan009_";

    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed");
        }
    }
}
