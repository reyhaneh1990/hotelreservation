package ir.reyhaneh.hotelreservation.repository;

import ir.reyhaneh.hotelreservation.model.Payments;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addPayment(Payments payment) {
        String sql = "INSERT INTO payments (amount, paymentDate, paymentMethod) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getPaymentMethod());
    }

}
