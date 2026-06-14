package ticket;

import customer.Customer;
import customer.CustomerDao;
import customer.CustomerDto;
import customer.CustomerMapper;

import java.util.NoSuchElementException;

public class RegisterEntryService {
    private final CustomerDao customerRepo;
    private final TicketDao ticketRepo;

    public RegisterEntryService(CustomerDao customerRepo, TicketDao ticketRepo) {
        this.customerRepo = customerRepo;
        this.ticketRepo = ticketRepo;
    }
    public void register(String plate) {
        if (plate == null) throw new IllegalArgumentException("Plate must not be null.");
        CustomerDto customerDto = customerRepo
                .findOne(plate)
                .orElseThrow(NoSuchElementException::new);

        Customer customer = CustomerMapper.toEntity(customerDto);

        Ticket ticket = new Ticket(customer);

        ticketRepo.save(TicketMapper.toDto(ticket));
    }
}
