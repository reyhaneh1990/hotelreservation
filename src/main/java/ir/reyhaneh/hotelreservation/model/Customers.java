package ir.reyhaneh.hotelreservation.model;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
//هدف: ذخیره اطلعات مربوط به مشتریانی که از هتل استفاده میکنند.

@Setter
@Getter
/* تمام موجودیت ها باید انوتیشن Entity داشته باشند*/
@Table(name = "customer")
public class Customers /* مسايل مربوط به سریالابزبل قبلا گفته شد*/ {
    @Id
    /* تولید اتوماتیک مقدار برای آی دی فراموش شده*/
    private long id;
    private String name;
    private String email; /* حرف اول فیلدها باید کوچک باشد*/
    private String phone; /* حرف اول فیلدها باید کوچک باشد*/
    private String address; /* حرف اول فیلدها باید کوچک باشد*/

    /* استفاده درست از اینتر زدن قبلا گفته شد */
}
