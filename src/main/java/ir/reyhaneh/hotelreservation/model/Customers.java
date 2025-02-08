package ir.reyhaneh.hotelreservation.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
//هدف: ذخیره اطلعات مربوط به مشتریانی که از هتل استفاده میکنند.

@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Bookings> bookings;


}
