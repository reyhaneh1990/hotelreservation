package ir.reyhaneh.hotelreservation.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

//هدف: نگهداری اطلعات مربوط به پرداختها.
@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payments {
    private long id;
    private long bookingId;
    private long amount;
    private long paymentDate;
    private Long paymentMethod;

}
