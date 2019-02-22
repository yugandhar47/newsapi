package com.example.news.newsPro.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.news.newsPro.pojo.User;

@RestController
@RequestMapping(path = "/user")
public class LoginController {
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody //sepcify a header here for string return instaead of json
	public String userLogin(@RequestBody User user) {
		System.out.println(user);
		return "{\"status\":\"ok\"}";
	}

}
