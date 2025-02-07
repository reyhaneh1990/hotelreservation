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
public class Rooms /* مسايل مربوط به سریالابزبل قبلا گفته شد*/   {
    private long id; /* موارد مربوط به آی دی قبلا در فایل دیگری گفته شد */
    private String roomType; /* این نوع فیلد ها که مقادیر مشخصی دارند و باید انتخاب کنی رو باید از نوع enum بگیری. براش یه enum میسازیم و این فیلد رو از اون نوع میگیریم */
    private String roomStatus; /* این نوع فیلد ها که مقادیر مشخصی دارند و باید انتخاب کنی رو باید از نوع enum بگیری. براش یه enum میسازیم و این فیلد رو از اون نوع میگیریم */
    private String roomPrice;/* مبلغ ها رو از نوع عددی میگیریم چون همه جا long گرفتی اینجا هم باید long بگیری */


}
