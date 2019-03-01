package com.project.demo.services;


import com.project.demo.models.detail;

import java.util.List;

public interface DetailService {
    List<detail> findAll();
    // List<catalog> findLatest5();
    detail findById(Integer  id);
    detail insert_details(detail details);
    detail update_details(detail details);
    void deleteById(Integer  id);
}
