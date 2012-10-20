package br.com.funtous.daos;

import java.util.List;

import br.com.funtous.entities.User;

public interface UserRepository {
	void save(User user);
	void remove(User user);
	void update(User user);
	User findById(Long id);
	List<User> getAll();
	User findByNamePassword(String name, String password);
}