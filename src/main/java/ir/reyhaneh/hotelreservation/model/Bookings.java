package ir.reyhaneh.hotelreservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//هدف: مدیریت اطلعات رزروهای انجام شده توسط مشتریان.
@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Bookings implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date bookingDate;

    private Date checkInDate;

    private Date checkOutDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payments payments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Booking_AdditionalService")
    private List<AdditionalService> additionalServices;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customers customers;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rooms rooms;
}
