package ir.reyhaneh.hotelreservation.service;

import ir.reyhaneh.hotelreservation.model.Payments;

import java.util.Date;
import java.util.List;

public interface PaymentsService {

    List<Payments> getAllPayments();

    Payments getPaymentsById(Long id);

    void savePayments(Long amount, Date paymentDate, String paymentMethod);

    void updatePayments(Long id, Long amount, Date paymentDate, String paymentMethod);

    void savePayments(Long id, Long amount, Date paymentDate, String paymentMethod);

    void updatepayments(Long id, Long amount, Date paymentDate, String paymentMethod);

    void deletePayments(Long id);

}
