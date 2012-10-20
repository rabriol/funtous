package br.com.funtous.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.funtous.entities.User;

@Repository
@Transactional
public class UserDAO implements UserRepository {
	@PersistenceContext
	private EntityManager em;
	
	public UserDAO() {
	}

	@Transactional
	public void save(User user) {
		em.persist(user);
	}

	@Transactional
	public void remove(User user) {
	}

	@Transactional
	public void update(User user) {
	}

	@Transactional(readOnly=true)
	public User findById(Long id) {
		return em.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<User> getAll() {
		Query query = em.createNativeQuery("select * from user", User.class);
		return query.getResultList();
	}
	
	@Transactional(readOnly=true)
	public User findByNamePassword(String nickname, String password) {
		Query query = em.createNamedQuery("User.findByNicknameAndPassword");
		query.setParameter("nickname", nickname);
		query.setParameter("password", password);
		User user = (User)query.getSingleResult();
		return user;
	}
}
