package ir.reyhaneh.hotelreservation.repository;

import ir.reyhaneh.hotelreservation.model.AdditionalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdditionalServiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addAdditionalService(AdditionalService additionalService) {
        String sql = "INSERT INTO additional_service (name, price) VALUES (?, ?)";
        jdbcTemplate.update(sql,
                additionalService.getName(),
                additionalService.getPrice());
    }

}
