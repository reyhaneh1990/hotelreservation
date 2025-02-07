package ir.reyhaneh.hotelreservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//هدف: مدیریت اطلعات رزروهای انجامشده توسط مشتریان.
@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Bookings /* مسايل مربوط به سریالابزبل قبلا گفته شد*/ {
    private long id; /* موارد مربوط به آی دی قبلا در فایل دیگری گفته شد */
    private long customerId; /* آی دی جداول دیگه رو به صورت فیلد نمی سازیم. میذاریم خود هایبرنیت برامون بسازه پس این خط باید حذف بشه */
    private long roomId; /* آی دی جداول دیگه رو به صورت فیلد نمی سازیم. میذاریم خود هایبرنیت برامون بسازه پس این خط باید حذف بشه */
    private Date bookingDate; /* تاریخ ها رو یا باید از نوع Date بگیریم یا از نوع String */
    private Date checkInDate; /* تاریخ ها رو یا باید از نوع Date بگیریم یا از نوع String */
    private Date checkOutDate; /* تاریخ ها رو یا باید از نوع Date بگیریم یا از نوع String */

/* استفاده درست از اینتر زدن قبلا گفته شد */
}
