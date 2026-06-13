package ticket;

import customer.Customer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Ticket {
    private UUID id;
    private LocalDateTime entry;
    private LocalDateTime exit;
    private Customer customer;

    public Ticket(Customer customer) {
        this.id = UUID.randomUUID();
        this.entry = LocalDateTime.now();
        this.customer = customer;
    }

    public Ticket(LocalDateTime entry, UUID id, Customer customer) {
        this.entry = entry;
        this.id = id;
        this.customer = customer;
    }

    public void exit() {
        this.exit = LocalDateTime.now();
    }

    public Duration parkingDuration() {
        if (exit == null) throw new IllegalStateException("Vehicle has not exited yet.");
        return Duration.between(entry, exit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(entry, ticket.entry) && Objects.equals(exit, ticket.exit) && Objects.equals(customer, ticket.customer);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", entry=" + entry +
                ", exit=" + exit +
                ", customer=" + customer +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entry, exit, customer);
    }

    public String getId() {
        return id.toString();
    }


    public LocalDateTime getEntry() {
        return entry;
    }

    public LocalDateTime getExit() {
        return exit;
    }

    public Customer getCustomer() {
        return customer;
    }
}
