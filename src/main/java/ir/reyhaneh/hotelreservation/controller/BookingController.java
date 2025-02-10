package ir.reyhaneh.hotelreservation.controller;

import ir.reyhaneh.hotelreservation.model.Bookings;
import ir.reyhaneh.hotelreservation.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(name = "/booking/")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public List<Bookings> getAllBooking() {
        return bookingService.getAllBookings();
    }

    @GetMapping("{id}")
    public Bookings getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("{customerId}/{roomId}/{checkInDate}/{checkOutDate}/{amount}/{paymentMethod}")
    public void saveBooking(@PathVariable Long customerId, @PathVariable Long roomId, @PathVariable Date checkInDate, @PathVariable Date checkOutDate, @PathVariable Long amount, @PathVariable String paymentMethod) {
        bookingService.saveBooking(customerId, roomId, checkInDate, checkOutDate, amount, paymentMethod);
    }


}
