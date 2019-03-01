package com.project.demo.services;

import com.project.demo.models.detail;
import com.project.demo.models.product;
import com.project.demo.models.product_file;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    // List<catalog> findLatest5();
    product findById(Integer  id);
    product insert_product(product products);
    product update_product(product products);
    void deleteById(Integer  id);
    Page<product> findAllPageable(Pageable pageable);
    List<product_file> findFilesByProductId(Integer id);
    List<product> findAll();
    List<detail> findAllDetailByIdProduct(Integer id);
    List<product> findProductByName(String Name);
}
