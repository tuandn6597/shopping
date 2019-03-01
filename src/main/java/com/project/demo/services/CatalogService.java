package com.project.demo.services;
import com.project.demo.models.catalog;

import java.util.List;

public interface CatalogService {
    List<catalog> findAll();
   // List<catalog> findLatest5();
    catalog findById(Integer  id);
    catalog insert_catalog(catalog catalogs);
    catalog update_catalog(catalog catalogs);
    void deleteById(Integer  id);
}
