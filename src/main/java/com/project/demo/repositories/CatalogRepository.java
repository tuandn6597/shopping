package com.project.demo.repositories;
import com.project.demo.models.catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CatalogRepository extends JpaRepository<catalog,Integer > {

}
