package com.project.demo.repositories;
import com.project.demo.models.producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerReposity  extends JpaRepository<producer,Integer> {
}
