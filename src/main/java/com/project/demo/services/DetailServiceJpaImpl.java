package com.project.demo.services;

import com.project.demo.models.detail;
import com.project.demo.repositories.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceJpaImpl implements DetailService {
    @Autowired
    private DetailRepository detailRepository;
    @Override
    public List<detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public detail findById(Integer id) {
        return detailRepository.findById(id).get();
    }

    @Override
    public detail insert_details(detail details) {
        return detailRepository.save(details);
    }

    @Override
    public detail update_details(detail details) {
        return detailRepository.save(details);
    }

    @Override
    public void deleteById(Integer id) {
    detailRepository.deleteById(id);
    }
}
