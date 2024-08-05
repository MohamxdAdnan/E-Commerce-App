package com.e_commerce_app.Controller;

import com.e_commerce_app.Dto.CustomerDto;
import com.e_commerce_app.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;
    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
        CustomerDto customerDto = customerService.getCustomer(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted", HttpStatus.NO_CONTENT);
    }
    @PutMapping("{id}")
    public ResponseEntity<CustomerDto> updateEmployee(@RequestBody CustomerDto customerDto, @PathVariable Long id) {
        CustomerDto updatedCustomer = customerService.updateCustomer(customerDto, id);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
}
