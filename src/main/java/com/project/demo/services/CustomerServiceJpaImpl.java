package com.project.demo.services;

import com.project.demo.models.customer;
import com.project.demo.models.producer;
import com.project.demo.repositories.CustomerRepository;
import com.project.demo.repositories.ProducerReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceJpaImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public customer findById(Integer id) {
        return this.customerRepository.findById(id).get();
    }

    @Override
    public customer insert_customer(customer customers) {
        return this.customerRepository.save(customers);
    }

    @Override
    public customer update_customer(customer customers) {
        return this.customerRepository.save(customers);
    }

    @Override
    public void deleteById(Integer id) {
        this.customerRepository.deleteById(id);
    }
    public List<customer> findByName(String Name){
        return this.customerRepository.findByName(Name);
    }
}
