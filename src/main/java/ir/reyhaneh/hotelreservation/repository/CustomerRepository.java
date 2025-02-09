package ir.reyhaneh.hotelreservation.repository;

import ir.reyhaneh.hotelreservation.model.Customers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addCustomer(Customers customers) {
        String sql = "INSERT INTO customer (name, email, phone, address) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                customers.getName(),
                customers.getEmail(),
                customers.getPhone(),
                customers.getAddress());
    }

}
