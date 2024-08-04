package com.e_commerce_app.Service;

import com.e_commerce_app.Dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer (CustomerDto customerDto);
    CustomerDto updatCustomer (CustomerDto customerDto,Long customerId);
    void deleteCustomer (Long customerId);
    CustomerDto getCustomer (Long customerId);
    List<CustomerDto> getAllCustomers ();
}
