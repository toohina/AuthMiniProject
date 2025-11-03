package com.example.authMiniProject.controller;

import com.example.authMiniProject.model.User;
import com.example.authMiniProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(){
        return  "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model){
       if(userRepository.findByUsername(username).isPresent()){
            model.addAttribute("error","The username already exists");
            return "register";
        }else{
            User newUser=new User(username,passwordEncoder.encode(password),"ROLE_USER");
            userRepository.save(newUser);
            return "redirect:/login?registered";
        }
    }

}
