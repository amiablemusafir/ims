package com.apsposting.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.apsposting.service.UserService;

@Controller
public class AuthController  {

	@Value("${spring.application.name}")
	String appName;

	private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

	// handler method to handle home page request
    @GetMapping("/login")
    public String home(){
        return "login";
    }

    // handler method to handle login request
    @PostMapping("/authentication")
    public String login(Model model){
    	model.addAttribute("appName", appName);
        return "users";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model){
    	model.addAttribute("appName", appName);
        return "dashboard";
    }
}
