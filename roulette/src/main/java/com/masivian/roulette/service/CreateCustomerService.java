package com.masivian.roulette.service;
import com.masivian.roulette.model.Customer;
import com.masivian.roulette.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CreateCustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer create(String name,Long creditAmount){
        Customer customer = Customer.createCustomer(name, creditAmount);
        customerRepository.save(customer);
        
        return customer;
    }
}