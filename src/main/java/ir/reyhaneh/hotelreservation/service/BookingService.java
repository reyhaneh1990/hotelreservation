package ir.reyhaneh.hotelreservation.service;

import ir.reyhaneh.hotelreservation.model.Bookings;
import ir.reyhaneh.hotelreservation.model.Payments;
import ir.reyhaneh.hotelreservation.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public void createBooking(Bookings booking, Payments payment) {
        // Save payment first
        // (Assume payment is saved in another repository)

        // Save booking
        bookingRepository.addBooking(booking);

        // Simulate an error for testing rollback
        if (payment.getAmount() <= 0) {
            throw new RuntimeException("Invalid payment amount");
        }
    }
}