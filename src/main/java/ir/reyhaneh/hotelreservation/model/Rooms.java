package ir.reyhaneh.hotelreservation.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

//هدف: نگهداری اطلعات مربوط به اتاقهای هتل.
@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Rooms {
    private long id;
    private String roomType;
    private String roomStatus;
    private String roomPrice;


}
