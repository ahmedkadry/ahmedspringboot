package com.A7meD.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.A7meD.springboot.models.UserDtls;
import com.A7meD.springboot.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/")
	public String homePage() {
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/register")
	public String register(@ModelAttribute UserDtls user, HttpSession session) {
		System.out.println("");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		session.setAttribute("message", "User Register Successfully");
		return "redirect:/";
	}

	@RequestMapping(value = "/welcome")
	public String welcomePage() {
		return "welcome";
	}

	@RequestMapping("/products")
	public String products() {
		return "products";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

}
