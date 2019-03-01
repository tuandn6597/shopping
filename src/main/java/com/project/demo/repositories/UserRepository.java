package com.project.demo.repositories;


import com.project.demo.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByEmail(String email);
}