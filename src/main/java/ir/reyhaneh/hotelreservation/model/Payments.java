package ir.reyhaneh.hotelreservation.model;

import ir.reyhaneh.hotelreservation.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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

    private PaymentMethod paymentMethod;

    @OneToOne(fetch = FetchType.LAZY)
    private Bookings bookings;
}