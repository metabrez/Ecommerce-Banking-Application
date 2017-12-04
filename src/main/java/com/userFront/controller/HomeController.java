package com.userFront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userFront.domain.User;
import com.userFront.service.UserService;

@Controller
public class HomeController {
	@Autowired
	
	private UserService userService;
	
	@RequestMapping("/")
	public String home() {
		
		return "redirect:/index";
	}
	@RequestMapping("/index")
public String homePage() {
	
	return "index";
}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signUp(Model model) {
		
		User user=new User();
		model.addAttribute("user",user);
		
		return "signup";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	
	public String signupPost(@ModelAttribute("user")User user,Model model) {
		
		if(userService.checkUserExists(user.getUsername(), user.getEmail())) {
			
			if(userService.checkUsernameExists(user.getUsername())) {
				
				model.addAttribute("usernameExists",true);
			}
			
			if(userService.checkUserEmailExists(user.getEmail())) {
				
				model.addAttribute("userEmailExists",true);
			}
			
			return "signup";
		}else {
			
			userService.save(user);
			
			return   "redirect:/";
		}
			
			
}}
