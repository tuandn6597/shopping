package com.project.demo.config;

import com.project.demo.models.Role;
import com.project.demo.models.User;
import com.project.demo.repositories.RoleRepository;
import com.project.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;


@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // Roles
        if (roleRepository.findRoleByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findRoleByName("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }

        // Admin account
        if (userRepository.findUserByEmail("admin@gmail.com") == null) {
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findRoleByName("ROLE_ADMIN"));
            roles.add(roleRepository.findRoleByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        // Member account
        if (userRepository.findUserByEmail("member@gmail.com") == null) {
            User user = new User();
            user.setEmail("member@gmail.com");
            user.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findRoleByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

}