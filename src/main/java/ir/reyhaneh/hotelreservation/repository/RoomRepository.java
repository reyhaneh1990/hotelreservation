package ir.reyhaneh.hotelreservation.repository;

import ir.reyhaneh.hotelreservation.model.Rooms;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addRoom(Rooms rooms) {
        String sql = "INSERT INTO rooms (type, status, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                rooms.getType(),
                rooms.getStatus(),
                rooms.getPrice());
    }

}
