package br.ifsp.infection.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqliteBulletinDao implements GenericDAO<Integer, BulletinDto> {
    @Override
    public void insert(BulletinDto value) {
        String sql = """
                INSERT INTO bulletins (
                    city,
                    state,
                    infected,
                    deaths,
                    icu_ratio,
                    date)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try(var stmt = ConnectionFactory.preparedStatement(sql)){
            dtoToStmt(value, stmt);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dtoToStmt(BulletinDto value, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, value.city());
        stmt.setString(2, value.state());
        stmt.setInt(3, value.infected());
        stmt.setInt(4, value.deaths());
        stmt.setDouble(5, value.icuRatio());
        stmt.setString(6, value.date());
    }

    @Override
    public void update(BulletinDto value) {
        String sql = """
                    UPDATE bulletins
                    SET 
                        city = ?,
                        state = ?,
                        infected = ?,
                        deaths = ?,
                        icu_ratio = ?,
                        date = ?
                    WHERE id = ?
                """;
        try(var stmt = ConnectionFactory.preparedStatement(sql)){
            dtoToStmt(value, stmt);
            stmt.setInt(7, value.id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE FROM bulletins WHERE id = ?";
        try(var stmt = ConnectionFactory.preparedStatement(sql)){
            stmt.setInt(1, key);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existsById(Integer key) {
        String sql = "SELECT 1 FROM bulletins WHERE id = ?";
        try(var stmt = ConnectionFactory.preparedStatement(sql)){
            stmt.setInt(1, key);
            final ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<BulletinDto> findAll() {
        String sql = "SELECT *  FROM bulletins";
        List<BulletinDto> result = new ArrayList<>();
        try(var stmt = ConnectionFactory.preparedStatement(sql)){
            final ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result.add(new BulletinDto(
                        rs.getInt("id"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getInt("infected"),
                        rs.getInt("deaths"),
                        rs.getDouble("icu_ratio"),
                        rs.getString("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
