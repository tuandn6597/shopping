package com.project.demo.services;

import com.project.demo.models.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<customer> findAll();
    customer findById(Integer id);
    customer insert_customer(customer customers);
    customer update_customer(customer customers);
    void deleteById(Integer id);
    List<customer> findByName(String Name);
}
