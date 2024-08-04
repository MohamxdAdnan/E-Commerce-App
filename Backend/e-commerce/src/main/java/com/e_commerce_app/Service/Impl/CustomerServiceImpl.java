package com.e_commerce_app.Service.Impl;

import com.e_commerce_app.Dto.CustomerDto;
import com.e_commerce_app.Entity.Customer;
import com.e_commerce_app.Exception.ResourceNotFoundException;
import com.e_commerce_app.Repository.CustomerRepository;
import com.e_commerce_app.Service.CustomerService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer=modelMapper.map(customerDto,Customer.class);
        Customer newCustomer = customerRepository.save(customer);
        return modelMapper.map(newCustomer,CustomerDto.class);
    }

    @Override
    public CustomerDto updatCustomer(CustomerDto customerDto, Long customerId) {
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer Not Found with ID : " + customerId));
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setPassword(customerDto.getPassword());

        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer,CustomerDto.class);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer Not Found with ID : " + customerId));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerDto getCustomer(Long customerId) {
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer Not Found with ID : " + customerId));

        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        List<CustomerDto> allCustomerDtos = allCustomers.stream()
                .map((customer)-> modelMapper.map(customer,CustomerDto.class))
                .collect(Collectors.toList());
        return allCustomerDtos;
    }
}
