package main;

import persistence.DatabaseBuilder;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseBuilder databaseBuilder = new DatabaseBuilder();
        databaseBuilder.createTables();
        databaseBuilder.populateDatabase();
    }
}
