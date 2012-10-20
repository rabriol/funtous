package br.com.funtous.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.funtous.daos.UserRepository;
import br.com.funtous.entities.User;

@Service("userService")
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserService() {
	}
	
	public List<User> getAllUsersActicateds() {
		return userRepository.getAll();
	}
	
	public User getUser(String nickname, String password) {
		return userRepository.findByNamePassword(nickname, password);
	}
	
	public void AddUser(User user) {
		userRepository.save(user);
	}

	public User searchById(Long id) {
		return userRepository.findById(id);
	}
}