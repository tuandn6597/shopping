package com.project.demo.services;

import com.project.demo.models.producer;
import com.project.demo.models.product;
import com.project.demo.repositories.ProducerReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProducerServiceJpaImpl implements ProducerService {
    @Autowired
    private ProducerReposity producerReposity;

    @Override
    public List<producer> findAll() {
        return this.producerReposity.findAll();
    }

    @Override
    public producer findById(Integer id) {
        return this.producerReposity.findById(id).get();
    }

    @Override
    public producer insert_producer(producer producers) {
        return this.producerReposity.save(producers);
    }

    @Override
    public producer update_producer(producer producers) {
        return this.producerReposity.save(producers);
    }

    @Override
    public void deleteById(Integer id) {
        this.producerReposity.deleteById(id);

    }
}
