package com.apsposting.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apsposting.service.UserService;

@Controller
@RequestMapping("/inventory")
public class InventoryController  {

	@Value("${spring.application.name}")
	String appName;

	private UserService userService;

    public InventoryController(UserService userService) {
        this.userService = userService;
    }

	@GetMapping("/addInventory")
    public String addInventory(Model model){
    	model.addAttribute("appName", appName);
        return "addinventory";
    }

}
