package com.project.demo.controllers;

import com.project.demo.models.Role;
import com.project.demo.models.User;
import com.project.demo.repositories.RoleRepository;
import com.project.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;

@Controller
public class loginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "page-login";
    }
    @GetMapping("/register")
    public String getRE() {
        return "page-register";
    }

    @GetMapping("/logoutsucess")
    public String logOut() {
        return "redirect:/login";
    }
    @PostMapping("/registerDK")
    public String getRegister(@RequestParam("email") String name, @RequestParam("pass") String pass, @RequestParam("check") String check, ModelMap modelMap) {
        if(check.equals("admin")) {
            if (userRepository.findUserByEmail(name) == null) {
                User user = new User();
                user.setEmail(name);
                user.setPassword(passwordEncoder.encode(pass));
                HashSet<Role> roles = new HashSet<>();
                roles.add(roleRepository.findRoleByName("ROLE_ADMIN"));
                user.setRoles(roles);
                userRepository.save(user);
                return "admin/index";

            } else {
                modelMap.addAttribute("loi", "trung ten");
                return "page-register";
            }
        }
        else if(check.equals("employee")) {
            if (userRepository.findUserByEmail(name) == null) {
                User user = new User();
                user.setEmail(name);
                user.setPassword(passwordEncoder.encode(pass));
                HashSet<Role> roles = new HashSet<>();
                roles.add(roleRepository.findRoleByName("ROLE_MEMBER"));
                user.setRoles(roles);
                userRepository.save(user);
                return "403";

            } else {
                modelMap.addAttribute("loi", "trung ten");
                return "page-register";
            }
        }
        else
            return "page-register";
    }

    @RequestMapping(value = "forget")
    public String getForget()
    {
        return "pages-forget";
    }
}