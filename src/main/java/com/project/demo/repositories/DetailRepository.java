package com.project.demo.repositories;

import com.project.demo.models.detail;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface DetailRepository extends JpaRepository<detail,Integer> {

}
