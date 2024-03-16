package com.example.sqldemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sqldemo.model.Customer;
import com.example.sqldemo.model.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String saveCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        if (savedCustomer != null) {
            System.out.println("Customer saved successfully with id: " + savedCustomer.getCustomerId());
            return "Success saved customer with id: " + savedCustomer.getCustomerId();
        } else {
            System.out.println("Failed to save customer.");
            return "Failed to save customer.";
        }
    }

    public Customer getCustomer(int id) {
        Customer customer = customerRepository.findById(id);
        if (customer != null) {
            System.out.println("Customer found with id: " + id);
        } else {
            System.out.println("Customer not found with id: " + id);
        }
        return customer;
    }

    // Create an update method
    public Customer updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getCustomerId())) {
            System.out.println("Customer with id " + customer.getCustomerId() + " exists. Updating...");
            Customer updatedCustomer = customerRepository.save(customer);
            System.out.println("Update successful for customer with id: " + updatedCustomer.getCustomerId());
            return updatedCustomer;
        } else {
            System.out.println("Customer with id " + customer.getCustomerId() + " does not exist. Cannot update.");
            return null; // Or handle the case according to your requirements
        }
    }
}
