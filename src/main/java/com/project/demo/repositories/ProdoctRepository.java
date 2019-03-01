package com.project.demo.repositories;
import com.project.demo.models.detail;
import com.project.demo.models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdoctRepository extends JpaRepository<product,Integer> {
    @Query("Select p from detail p where p.product.id= ?1")
    List<detail> findAllDetailByIdProduct(Integer id);
    @Query("Select p from product p where p.name like %:Name%")
    List<product> findProductByName(String Name);
}
