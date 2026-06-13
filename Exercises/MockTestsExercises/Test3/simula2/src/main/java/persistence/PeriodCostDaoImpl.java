package persistence;

import costs.PeriodCostDao;
import costs.PeriodCostDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodCostDaoImpl implements PeriodCostDao {
    @Override
    public List<PeriodCostDto> findAll() {
        String query = "SELECT hours, fee FROM period_costs";
        List<PeriodCostDto> list = new ArrayList<>();
        try (var stmt = ConnectionFactory.getConnection()) {
            var resp = stmt.prepareStatement(query).executeQuery();
            while (resp.next()) {
                list.add(new PeriodCostDto(resp.getInt("hours"), resp.getDouble("free")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
