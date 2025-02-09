package ir.reyhaneh.hotelreservation.controller;

import ir.reyhaneh.hotelreservation.model.Customers;
import ir.reyhaneh.hotelreservation.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(name = "/customer/")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customers> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public Customers getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("{name}/{email}/{phone}/{address}")
    public void saveCustomer(@PathVariable String name, @PathVariable String email, @PathVariable String phone, @PathVariable String address) {
        customerService.saveCustomer(name, email, phone, address);
    }

    @PutMapping("{id}/{name}/{email}/{phone}/{address}")
    public void updateCustomer(@PathVariable Long id, @PathVariable String name, @PathVariable String email, @PathVariable String phone, @PathVariable String address) {
        customerService.updateCustomer(id, name, email, phone, address);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }


}
