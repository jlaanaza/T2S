package com.t2s.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2s.web.impl.ContainerRepositoryImpl;
import com.t2s.web.model.Container;
import com.t2s.web.repository.ContainerRepository;

@Service
public class ContainerService {

	@Autowired
	private ContainerRepository containerRepository;

	@Autowired
	private ContainerRepositoryImpl containerRepositoryImpl;

	public List<Container> findAll() throws Exception {
		return this.containerRepository.findAll();
	}

	public Container findById(Long id) throws Exception {
		Optional<Container> container = this.containerRepository.findByIdAndIsEnabled(id, true);
		return container != null ? container.get() : null;
	}

	public Container save(Container container) throws Exception {
		return this.containerRepository.save(container);
	}

	public void delete(Long id) throws Exception {
		this.containerRepositoryImpl.delete(id);
	}

}
