package br.com.funtous.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.funtous.entities.Media;
import br.com.funtous.entities.User;
import br.com.funtous.services.MediaService;
import br.com.funtous.services.UserService;

@ManagedBean(name="homeBean")
@SessionScoped
public class HomeBean {
	@ManagedProperty(value="#{userService}")
	private UserService userService;
	@ManagedProperty(value="#{mediaService}")
	private MediaService mediaService;

	private User user;
	private List<User> users = new ArrayList<User>();
	private List<Media> medias = new ArrayList<Media>();
	private List<Media> partialMedias = new ArrayList<Media>();
	private Integer lastPicked = 0;
	
	private String searchTerm;
	
	public HomeBean() {
	}
	
	@PostConstruct
	public void init() {
		if (users.isEmpty()) {
			users = userService.getAllUsersActicateds();
		}
		if (medias.isEmpty()) {
			medias = mediaService.serachAll();
		}
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> userList) {
		this.users = userList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
	
	public String getSearchTerm() {
		return searchTerm;
	}
	
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public List<Media> getPartialMedias() {
		System.out.println("O valor atual do lastPicked eh "+ lastPicked);
		if (medias.size() > lastPicked+5) {
			partialMedias = medias;
			lastPicked += 5;
			return partialMedias;
		} else if (medias.size() < lastPicked+5 && medias.size() > lastPicked) { 
			partialMedias = medias.subList(lastPicked, medias.size());
			return partialMedias;
		} else {
			return null;
		}
	}

	public void setPartialMedias(List<Media> partialMedias) {
		this.partialMedias = partialMedias;
	}
}
