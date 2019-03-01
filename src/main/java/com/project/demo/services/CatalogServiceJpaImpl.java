package com.project.demo.services;

import com.project.demo.models.catalog;
import com.project.demo.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CatalogServiceJpaImpl implements CatalogService {
    @Autowired
    private CatalogRepository CatalogRepo;
    @Override
    public List<catalog> findAll() {
        return this.CatalogRepo.findAll();
    }

    @Override
    public catalog findById(Integer  id) {
      return this.CatalogRepo.findById(id).get();
    }


    @Override
    public catalog insert_catalog(catalog catalogs) {
        return this.CatalogRepo.save(catalogs);
    }

    @Override
    public catalog update_catalog(catalog catalogs) {
        return this.CatalogRepo.save(catalogs);
    }

    @Override
    public void deleteById(Integer  id) {
       this.CatalogRepo.deleteById(id);


    }
}
