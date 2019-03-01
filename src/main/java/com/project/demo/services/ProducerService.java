package com.project.demo.services;

import java.util.List;
import com.project.demo.models.producer;
public interface ProducerService {
    List<producer> findAll();
    // List<catalog> findLatest5();
    producer findById(Integer  id);
    producer insert_producer(producer producers);
    producer update_producer(producer producers);
    void deleteById(Integer  id);
}
