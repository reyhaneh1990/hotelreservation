package ir.reyhaneh.hotelreservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//هدف: نگهداری اطلعات مربوط به خدمات اضافی که مشتریان میتوانند درخواست دهند.
@Getter
@Setter
@Entity
@Table(name = "additionalService")
public class AdditionalService /* ما معمولا همه موجودیت ها رو از Serializable ایمپلیمنت میکنیم */ implements Serializable {

    /* برای مرتب شدن کدت حتما هر چیز رو از چیز بعدی با زدن اینتر و اضافه کردن یک خط خالی جدا کن */

    /* فیلد مربوط به آی دی باید با استفاده از انوتیشن @Id نشانه کذاری بشه*/
    /* برای اینکه مقدار آی دی به صورت خودکار درج بشه و ما نخوایم خودمون آی دی رو تولید کنیم باید از انوتیشن GeneratedValue با استراتژی اتوماتیک استفاده کنیم. یعنی خودش برامون مقدار را جنریت میکنه به صورت اتوماتیک  */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private long price;

}
