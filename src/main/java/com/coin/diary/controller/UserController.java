package com.coin.diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
