package br.com.funtous.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.funtous.daos.MediaRepository;
import br.com.funtous.entities.Media;

@Service("mediaService")
public class MediaService {
	@Autowired
	MediaRepository mediaRepository;
	
	public MediaService() {
	}
	
	public void save(Media media) {
		mediaRepository.save(media);
	}
	
	public Media search(Long id) {
		return mediaRepository.search(id);
	}

	public List<Media> serachAll() {
		return mediaRepository.searchAll();
	}
}