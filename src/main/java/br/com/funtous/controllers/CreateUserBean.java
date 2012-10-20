package br.com.funtous.controllers;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.com.funtous.entities.User;
import br.com.funtous.services.UserService;

@ManagedBean(name="createUserBean")
@ViewScoped
public class CreateUserBean {
	@ManagedProperty(value="#{userService}")
	private UserService service;
	private User user;
	
	public CreateUserBean() {
		user = new User();
	}
	
	public String save() {
		if (user.getName() != null) {
			user.setAge(Calendar.getInstance().getTime());
			service.AddUser(user);
		}
		return "home";
	}
	
	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
