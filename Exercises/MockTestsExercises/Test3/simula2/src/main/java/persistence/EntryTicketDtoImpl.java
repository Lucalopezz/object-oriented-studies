package persistence;

import ticket.EntryTicketDto;
import ticket.ExitTicketDto;
import ticket.TicketDao;


import java.sql.SQLException;
import java.util.Optional;

public class EntryTicketDtoImpl implements TicketDao {
    @Override
    public void save(EntryTicketDto entryTicketDto) {
        String sql = "INSERT INTO ticket (ID, plate, entry) VALUES (?, ?, ?)";
        try (var stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            stmt.setString(1, entryTicketDto.id());
            stmt.setString(2, entryTicketDto.plate());
            stmt.setString(3, entryTicketDto.entry());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<EntryTicketDto> findOpenTicket(String plate) {
        String query = "SELECT ID, plate, entry FROM ticket WHERE plate = ? AND exit IS NULL";
        try (var stmt = ConnectionFactory.getConnection().prepareStatement(query)) {
            stmt.setString(1, plate);
            var rs = stmt.executeQuery();
            return rs.next() ? Optional.of(new EntryTicketDto(
                    rs.getString("ID"),
                    rs.getString("plate"),
                    rs.getString("entry"))) : Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateExit(ExitTicketDto exitTicketDto) {
        String sql = """
                UPDATE ticket
                SET exit = ?, fee = ?
                WHERE plate = ? AND exit IS NULL
                """;
        try (var stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            stmt.setString(1, exitTicketDto.exit());
            stmt.setDouble(2, exitTicketDto.fee());
            stmt.setString(3, exitTicketDto.plate());


            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}





















