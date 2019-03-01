package com.project.demo.repositories;

import com.project.demo.models.product_file;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface ProductFileReposity extends JpaRepository<product_file,Integer> {

    @Query("select f from product_file as f where f.products.id =?1")
    List<product_file> findFilesByProductId(Integer id);
    @Modifying
    @Transactional
    @Query("delete from product_file as f where f.products.id=?1 and f.modifiledFileName in (?2)")
    void deleteFilesByProductIdAndImageName(Integer id,List<String> removeImages);
}
