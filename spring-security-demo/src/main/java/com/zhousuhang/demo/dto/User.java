package com.zhousuhang.demo.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.zhousuhang.demo.validator.MyConstraint;

public class User {
	
	public interface UserSimpleView {};
	public interface UserDetailView extends UserSimpleView {};
	
	@JsonView(UserSimpleView.class)
	private Integer id;
	
	@JsonView(UserSimpleView.class)
	@MyConstraint(message = "this is a validator test")
	private String username;
	
	@JsonView(UserDetailView.class)
	@NotBlank
	private String password;
	
	@JsonView(UserSimpleView.class)
	private Date birthday;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
