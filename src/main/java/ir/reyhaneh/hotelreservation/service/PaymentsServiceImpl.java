package ir.reyhaneh.hotelreservation.service;

import ir.reyhaneh.hotelreservation.model.Payments;
import ir.reyhaneh.hotelreservation.repository.PaymentsRepository;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentsServiceImpl implements PaymentsService {

//    @Autowired
//    private CustomerRepository CustomerRepository;

    private final PaymentsRepository paymentsRepository;

//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @Override
    public List<Payments> getAllPayments() {
        return paymentsRepository.getAllPayments();
    }


    @Override
    public Payments getPaymentsById(Long id) {
        return paymentsRepository.getPayments(id);
    }

    @Override
    public void savePayments(Long amount, Date paymentDate, String paymentMethod) {

    }

    @Override
    public void updatePayments(Long id, Long amount, Date paymentDate, String paymentMethod) {

    }

    @Override
    public void savePayments(Long id, Long amount, Date paymentDate, String paymentMethod) {
        if (paymentMethod.isEmpty()) {
            throw new ValidationException("Type is empty");
        }

        paymentsRepository.addPayments(amount, paymentDate, paymentMethod);
    }

    @Override
    public void updatepayments(Long id, Long amount, Date paymentDate, String paymentMethod) {
        if (id == null) {
            throw new ValidationException("id is null");
        }
        if (getPaymentsById(id) == null) {
            throw new ValidationException("Payments is not found");
        }

        paymentsRepository.editPayments(id, amount, paymentDate, paymentMethod);
    }

    @Override
    public void deletePayments(Long id) {
        if (id == null) {
            throw new ValidationException("id is null");
        }
        if (getPaymentsById(id) == null) {
            throw new ValidationException("Payments is not found");
        }

        paymentsRepository.deletePayments(id);
    }
}

