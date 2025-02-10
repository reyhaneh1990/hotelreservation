package ir.reyhaneh.hotelreservation.controller;

import ir.reyhaneh.hotelreservation.model.Payments;
import ir.reyhaneh.hotelreservation.service.PaymentsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping("{ amount}/{ paymentDate}/{paymentMethod}")
    public void savePayments(@PathVariable Long amount, @PathVariable Date paymentDate, @PathVariable String paymentMethod) {
        paymentsService.savePayments(amount, paymentDate, paymentMethod);
    }

    @PutMapping("{id}/{ amount}/{ paymentDate}/{paymentMethod}")
    public void updatePayments(@PathVariable Long id, @PathVariable Long amount, @PathVariable Date paymentDate, @PathVariable String paymentMethod) {
        paymentsService.updatePayments(id, amount, paymentDate, paymentMethod);
    }

    @DeleteMapping("{id}")
    public void deletePayments(@PathVariable Long id) {
        paymentsService.deletePayments(id);
    }


}
