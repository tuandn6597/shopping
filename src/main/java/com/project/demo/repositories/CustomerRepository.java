package com.project.demo.repositories;
import com.project.demo.models.customer;
import com.project.demo.models.producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<customer,Integer>{
    @Query("SELECT e FROM customer e WHERE e.Name like %:Name%")
    List<customer> findByName(String Name);
}
