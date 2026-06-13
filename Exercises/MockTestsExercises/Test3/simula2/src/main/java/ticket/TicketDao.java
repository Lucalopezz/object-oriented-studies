package ticket;

import java.util.Optional;

public interface TicketDao {
    void save(EntryTicketDto entryTicketDto);
    Optional<EntryTicketDto> findOpenTicket(String plate);
    void updateExit(ExitTicketDto exitTicketDto);
}
