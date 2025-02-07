package ir.reyhaneh.hotelreservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//هدف: نگهداری اطلعات مربوط به خدمات اضافی که مشتریان میتوانند درخواست دهند.
@Getter
@Setter
@Entity
@Table(name = "additionalService")
public class AdditionalService {
    private long id;
    private String name;
    private long price;
}
