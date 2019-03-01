package com.project.demo.repositories;

import com.project.demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByName(String name);

}
