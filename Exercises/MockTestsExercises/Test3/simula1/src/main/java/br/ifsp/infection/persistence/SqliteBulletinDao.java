package br.ifsp.infection.persistence;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.model.State;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SqliteBulletinDao implements GenericDAO<Integer, Bulletin> {

    @Override
    public void insert(Bulletin value) {
        String sql = "INSERT INTO bulletins (city, state, infected, deaths, icu_ratio, date) VALUES ( ?, ?, ?, ?, ?, ?)";

        try (var stmt = ConnectionFactory.prepareStatement(sql)) {
            stmt.setString(1, value.getCity());
            stmt.setString(2, value.getState().toString());
            stmt.setInt(3, value.getInfected());
            stmt.setInt(4, value.getDeaths());
            stmt.setDouble(5, value.getIcuRatio());
            stmt.setString(6, value.getDate().toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Bulletin value) {
        String sql = "UPDATE bulletins SET city = ?, state = ?, infected = ?, deaths = ?, icu_ratio = ?, date = ? WHERE id = ?";

        try (var stmt = ConnectionFactory.prepareStatement(sql)) {
            stmt.setString(1, value.getCity());
            stmt.setString(2, value.getState().toString());
            stmt.setInt(3, value.getInfected());
            stmt.setInt(4, value.getDeaths());
            stmt.setDouble(5, value.getIcuRatio());
            stmt.setString(6, value.getDate().toString());
            stmt.setInt(7, value.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE FROM bulletins WHERE id = ?";

        try (var stmt = ConnectionFactory.prepareStatement(sql)) {
            stmt.setInt(1, key);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Integer key) {
        String sql = "SELECT 1 FROM bulletins WHERE id = ?";

        try (var stmt = ConnectionFactory.prepareStatement(sql)) {
            stmt.setInt(1, key);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bulletin> findAll() {
        String sql = "SELECT id, city, state, infected, deaths, icu_ratio, date FROM bulletins";

        try (var stmt = ConnectionFactory.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                var list = new ArrayList<Bulletin>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String city = rs.getString("city");
                    String stateName = rs.getString("state");
                    State state = State.fromName(stateName);
                    int infected = rs.getInt("infected");
                    int deaths = rs.getInt("deaths");
                    double icuRatio = rs.getDouble("icu_ratio");
                    LocalDate date = LocalDate.parse(rs.getString("date"));

                    list.add(new Bulletin(id, city, state, infected, deaths, icuRatio, date));
                }
                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
