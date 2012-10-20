package br.com.funtous.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.funtous.entities.User;
import br.com.funtous.services.UserService;

@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean {
	@ManagedProperty(value="#{userService}")
	private UserService service;
	private String nickname;
	private String password;
	
	public LoginBean() {
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String newUser() {
		return "new";
	}
	
	public String executeLogin() {
		if (nickname == null) {
			throw new IllegalArgumentException("");
		}
		User userRetrived = service.getUser(nickname, password);
		return "home";
	}

	private Boolean validateUserAccess(User user) {
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
}
