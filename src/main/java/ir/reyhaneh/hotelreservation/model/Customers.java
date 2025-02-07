package ir.reyhaneh.hotelreservation.model;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
//هدف: ذخیره اطلعات مربوط به مشتریانی که از هتل استفاده میکنند.

@Setter
@Getter
@Table(name = "customer")
public class Customers {
    @Id
    private long id;
    private String name;
    private String Email;
    private String Phone;
    private String Address;
}
