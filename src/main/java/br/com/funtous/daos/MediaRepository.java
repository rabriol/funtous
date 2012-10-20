package br.com.funtous.daos;

import java.util.List;

import br.com.funtous.entities.Media;

public interface MediaRepository {
	
	void save(Media media);
	
	void remove(Media media);
	
	void update(Media media);
	
	Media search(Long id);
	
	List<Media> searchAll();
}
