package ir.reyhaneh.hotelreservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//هدف: مدیریت اطلعات رزروهای انجامشده توسط مشتریان.
@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Bookings {
    private long id;
    private long customerId;
    private long roomId;
    private long bookingDate;
    private long checkInDate;
    private long checkOutDate;


}
