package com.project.demo.repositories;

import com.project.demo.models.transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<transaction,Integer> {
}
