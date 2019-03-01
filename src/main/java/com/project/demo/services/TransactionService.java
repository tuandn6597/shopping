package com.project.demo.services;

import com.project.demo.models.transaction;

import java.util.List;

public interface TransactionService {
    List<transaction> findAll();
    // List<catalog> findLatest5();
    transaction findById(Integer  id);
    transaction insert_transaction(transaction transactions);
    transaction update_transaction(transaction transactions);
    void deleteById(Integer  id);
}
