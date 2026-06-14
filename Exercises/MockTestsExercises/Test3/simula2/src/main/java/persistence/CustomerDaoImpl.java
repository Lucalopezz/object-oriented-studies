package persistence;


import costs.PeriodCostDto;
import customer.CustomerDao;
import customer.CustomerDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(CustomerDto customerDto) {
        String sql = "INSERT INTO customer (plate, phone, type) VALUES (?, ?, ?)";
        try (var stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            stmt.setString(1, customerDto.plate());
            stmt.setString(2, customerDto.plate());
            stmt.setString(3, customerDto.type());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<CustomerDto> findOne(String plate) {
        String sql = "SELECT * FROM customer WHERE plate = ?";
        try (var stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            stmt.setString(1, plate);
            final ResultSet rs = stmt.executeQuery();
            return rs.next() ? Optional.of(new CustomerDto(
                    rs.getString("plate"),
                    rs.getString("phone"),
                    rs.getString("type"))) : Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
