package ir.reyhaneh.hotelreservation.repository;

import ir.reyhaneh.hotelreservation.model.Bookings;
import ir.reyhaneh.hotelreservation.model.Customers;
import ir.reyhaneh.hotelreservation.model.Payments;
import ir.reyhaneh.hotelreservation.model.Rooms;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addBooking(Bookings bookings, Customers customers, Rooms rooms, Payments payments) {
        String sql = "INSERT INTO bookings (bookingDate, checkInDate, checkOutDate, customer_id, room_id, payment_id) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                bookings.getBookingDate(),
                bookings.getCheckInDate(),
                bookings.getCheckOutDate(),
                customers.getId(),
                rooms.getId(),
                payments.getId());
    }

}
