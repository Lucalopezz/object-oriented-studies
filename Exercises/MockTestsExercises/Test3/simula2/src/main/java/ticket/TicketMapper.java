package ticket;

import customer.Customer;

import java.time.LocalDateTime;
import java.util.UUID;

public class TicketMapper {
    public static EntryTicketDto toDto(Ticket ticket) {
        return new EntryTicketDto(
                ticket.getId(),
                ticket.getCustomer().getPlate(),
                ticket.getEntry().toString()
        );
    }

    public static Ticket toEntity(EntryTicketDto dto, Customer customer) {
        return new Ticket(LocalDateTime.parse(dto.entry()), UUID.fromString(dto.id()), customer);
    }
}
