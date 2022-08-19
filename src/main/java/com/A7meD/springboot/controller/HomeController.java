package com.A7meD.springboot.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.A7meD.springboot.models.UserDtls;
import com.A7meD.springboot.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/home")
	public String homePage(Principal p, Model m) {
		String name = p.getName();
		UserDtls user = userRepository.findByEmail(name);
		m.addAttribute("fullname", user.getFullname());
		return "home";
	}

}
