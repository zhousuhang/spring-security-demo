package com.zhousuhang.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhousuhang.demo.dto.User;
import com.zhousuhang.demo.dto.UserQueryCondition;

@RestController
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> query(UserQueryCondition condition) {
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public User details(@PathVariable int id) {
		User user = new User();
		user.setUsername("tom");
		return user;
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public User create(@RequestBody User user) {
		user.setId(1);
		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		return user;
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public User update(@RequestBody User user, @PathVariable int id) {
		
		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		return user;
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		
//		return user;
	}
	
}
