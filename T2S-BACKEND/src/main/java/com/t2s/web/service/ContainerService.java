package com.t2s.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2s.web.model.Container;
import com.t2s.web.repository.ContainerRepository;

@Service
public class ContainerService {

	@Autowired
	private ContainerRepository containerRepository;

	public List<Container> findAll() throws Exception {
		return this.containerRepository.findAll();
	}

}
