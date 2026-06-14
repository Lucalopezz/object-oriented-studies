package ticket;

import costs.PeriodCostDao;
import costs.PeriodCostDto;
import customer.Customer;
import customer.CustomerDao;
import customer.CustomerDto;
import customer.CustomerMapper;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class RegisterExitService {
    private final CustomerDao customerRepo;
    private final TicketDao ticketRepo;
    private final PeriodCostDao periodCostRepo;

    public RegisterExitService(CustomerDao customerRepo, TicketDao ticketRepo, PeriodCostDao periodCostRepo) {
        this.customerRepo = customerRepo;
        this.ticketRepo = ticketRepo;
        this.periodCostRepo = periodCostRepo;
    }

    public double register(String plate) {
        if (plate == null) throw new IllegalArgumentException("Plate must not be null.");
        CustomerDto customerDto = customerRepo
                .findOne(plate)
                .orElseThrow(NoSuchElementException::new);

        EntryTicketDto entryTicketDto = ticketRepo
                .findOpenTicket(plate)
                .orElseThrow(IllegalStateException::new);

        Ticket ticket = TicketMapper.toEntity(entryTicketDto, CustomerMapper.toEntity(customerDto));

        ticket.exit();

        long hours = ticket.parkingDuration();

        double fee = calculateFee((int) hours);

        ticketRepo.updateExit(new ExitTicketDto(plate, ticket.getExit().toString(), fee));

        return fee;

    }

    private double calculateFee(int hours) {
        List<PeriodCostDto> plans = periodCostRepo.findAll();


        return calculate(hours, plans);
    }

    private double calculate(long hoursRemaning, List<PeriodCostDto> plans) {
        if (hoursRemaning <= 0) return 0;

        return plans.stream().mapToDouble(plan -> plan.fee()
                + calculate((hoursRemaning - plan.hours()), plans)).min().orElseThrow();
    }
}
