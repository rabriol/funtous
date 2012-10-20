package br.com.funtous.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.funtous.entities.Media;
@Repository
@Transactional
public class MediaDAO implements MediaRepository {
	@PersistenceContext
	private EntityManager em;
	
	public MediaDAO() {
	}

	public void save(Media moment) {
		em.persist(moment);
	}

	public void remove(Media media) {
		em.merge(media);
		em.remove(media);
	}

	public void update(Media media) {
		em.merge(media);
	}

	public Media search(Long id) {
		return em.find(Media.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Media> searchAll() {
		Query query = em.createNamedQuery("Media.findAll");
		return query.getResultList();
	}
}
