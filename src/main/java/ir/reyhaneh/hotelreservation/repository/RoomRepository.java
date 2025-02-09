package ir.reyhaneh.hotelreservation.repository;

import ir.reyhaneh.hotelreservation.model.Customers;
import ir.reyhaneh.hotelreservation.model.Rooms;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Rooms> RoomRowMapper = new RowMapper<Rooms>() {
        @Override
        public Rooms mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Rooms(
                    rs.getLong("id"),
                    rs.getString("type"),
                    rs.getString("status"),
                    rs.getLong("price")
            );
        }
    };

    @Transactional
    public void addRoom(String type, String status,Long price) {
        String sql = "INSERT INTO room (type, status, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                type,
                status,
                price);
    }

    @Transactional
    public void editRoom(String type, String status,Long price) {
        String sql = "INSERT INTO room (type, status, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                type,
                status,
                price);
    }

    @Transactional
    public void deleteRoom(Long id) {
        String sql = "DELETE from room WHERE id=?";
        jdbcTemplate.update(sql,
                id);
    }

    @Transactional
    public Rooms getRoom(Long id) {
        String sql = "SELECT * FROM Room WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,RoomRowMapper, id);
    }

    public List<Rooms> getAllRoom() {
        String sql = "SELECT * FROM Room";
        return jdbcTemplate.query(sql,RoomRowMapper);
    }

}
