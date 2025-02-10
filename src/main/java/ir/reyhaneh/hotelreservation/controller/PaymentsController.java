package ir.reyhaneh.hotelreservation.controller;

import ir.reyhaneh.hotelreservation.model.Payments;
import ir.reyhaneh.hotelreservation.service.PaymentsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(name = "/payments/")
public class PaymentsController {

    private final PaymentsService paymentsService;

    @GetMapping
    public List<Payments> getAllPayments() {
        return paymentsService.getAllPayments();
    }

    @GetMapping("{id}")
    public Payments getPaymentsById(@PathVariable Long id) {
        return paymentsService.getPaymentsById(id);
    }

}
