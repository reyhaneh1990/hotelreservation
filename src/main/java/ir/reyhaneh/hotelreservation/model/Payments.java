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
public class Payments /* مسايل مربوط به سریالابزبل قبلا گفته شد*/  {
    private long id; /* موارد مربوط به آی دی قبلا در فایل دیگری گفته شد */
    private long bookingId; /* آی دی جداول دیگه رو به صورت فیلد نمی سازیم. میذاریم خود هایبرنیت برامون بسازه پس این خط باید حذف بشه */
    private long amount;
    private long paymentDate; /* تاریخ ها رو یا باید از نوع Date بگیریم یا از نوع String */
    private Long paymentMethod; /* این نوع فیلد ها که مقادیر مشخصی دارند و باید انتخاب کنی رو باید از نوع enum بگیری. براش یه enum میسازیم و این فیلد رو از اون نوع میگیریم */
    /* استفاده درست از اینتر زدن قبلا گفته شد */
}
