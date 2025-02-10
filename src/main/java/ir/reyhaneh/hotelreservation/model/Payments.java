package ir.reyhaneh.hotelreservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

//هدف: نگهداری اطلعات مربوط به پرداختها.
@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;

    private Date paymentDate;

    private String paymentMethod;

    @OneToOne(fetch = FetchType.LAZY)
    private Bookings bookings;

    public Payments(long id, long amount, java.sql.Date paymentDate, String paymentMethod) {
    }
}