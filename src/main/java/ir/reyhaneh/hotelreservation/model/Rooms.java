package ir.reyhaneh.hotelreservation.model;

import ir.reyhaneh.hotelreservation.enums.RoomStatus;
import ir.reyhaneh.hotelreservation.enums.RoomType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.List;

//هدف: نگهداری اطلعات مربوط به اتاقهای هتل.

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Rooms implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private RoomType type;

    private RoomStatus status;

    private long price;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Bookings> bookings;

}
