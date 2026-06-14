package main;

import customer.RegisterCustomerService;
import customer.VehicleType;
import persistence.CustomerDaoImpl;
import persistence.DatabaseBuilder;
import persistence.EntryTicketDtoImpl;
import persistence.PeriodCostDaoImpl;
import ticket.RegisterEntryService;
import ticket.RegisterExitService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseBuilder databaseBuilder = new DatabaseBuilder();
        databaseBuilder.createTables();
        databaseBuilder.populateDatabase();


        RegisterCustomerService registerCustomerService = new RegisterCustomerService(new CustomerDaoImpl());
        RegisterEntryService registerEntryService = new RegisterEntryService(new CustomerDaoImpl(), new EntryTicketDtoImpl());
        RegisterExitService registerExitService = new RegisterExitService(new CustomerDaoImpl(), new EntryTicketDtoImpl(), new PeriodCostDaoImpl());

        registerCustomerService.register("Teste123", "12345", VehicleType.CAR);
        registerEntryService.register("Teste123");
        System.out.println(registerExitService.register("POO0007"));

    }
}
