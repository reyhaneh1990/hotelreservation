package ir.reyhaneh.hotelreservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

//هدف: نگهداری اطلعات مربوط به خدمات اضافی که مشتریان میتوانند درخواست دهند.
@Getter
@Setter
@Entity
@Table(name = "additional_service")
public class AdditionalService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long price;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Bookings> bookings;
}
