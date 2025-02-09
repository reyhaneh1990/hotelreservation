package ir.reyhaneh.hotelreservation.repository;

import ir.reyhaneh.hotelreservation.model.Bookings;
import ir.reyhaneh.hotelreservation.model.Customers;
import ir.reyhaneh.hotelreservation.model.Payments;
import ir.reyhaneh.hotelreservation.model.Rooms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookingRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookingRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public int addBooking(Bookings bookings, Customers customers, Rooms rooms, Payments payments) {
        // بررسی null نبودن ورودی‌ها
        if (bookings == null || customers == null || rooms == null || payments == null) {
            throw new IllegalArgumentException("Booking, customer, room, or payment cannot be null");
        }

        try {
            String sql = "INSERT INTO bookings (bookingDate, checkInDate, checkOutDate, customer_id, room_id, payment_id) VALUES (?, ?, ?, ?, ?, ?)";
            int rowsAffected = jdbcTemplate.update(sql,
                    bookings.getBookingDate(),
                    bookings.getCheckInDate(),
                    bookings.getCheckOutDate(),
                    customers.getId(),
                    rooms.getId(),
                    payments.getId());
            logger.info("Booking added successfully. Rows affected: {}", rowsAffected);
            return rowsAffected;
        } catch (Exception e) {
            logger.error("Error occurred while adding booking: {}", e.getMessage());
            throw e;
        }
    }
}