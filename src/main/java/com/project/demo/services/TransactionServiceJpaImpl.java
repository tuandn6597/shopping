package com.project.demo.services;

import com.project.demo.models.transaction;
import com.project.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceJpaImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public List<transaction> findAll() {
        return this.transactionRepository.findAll();
    }

    @Override
    public transaction findById(Integer id) {
        return this.transactionRepository.findById(id).get();
    }

    @Override
    public transaction insert_transaction(transaction transactions) {
        return this.transactionRepository.save(transactions);
    }

    @Override
    public transaction update_transaction(transaction transactions) {
        return this.transactionRepository.save(transactions);
    }

    @Override
    public void deleteById(Integer id) {
        this.transactionRepository.deleteById(id);

    }
}
