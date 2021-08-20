package com.t2s.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2s.web.impl.MovementRepositoryImpl;
import com.t2s.web.model.Movement;
import com.t2s.web.repository.MovementRepository;

@Service
public class MovementService {

	@Autowired
	private MovementRepository movementRepository;

	@Autowired
	private MovementRepositoryImpl movementRepositoryImpl;

	public List<Movement> findAll() throws Exception {
		return this.movementRepository.findAll();
	}

	public Movement findById(Long id) throws Exception {
		Optional<Movement> Movement = this.movementRepository.findByIdAndIsEnabled(id, true);
		return Movement != null ? Movement.get() : null;
	}

	public List<Movement> findByContainerId(Long id) throws Exception {
		List<Movement> movements = this.movementRepository.findByContainerId(id);
		return movements;
	}

	public Movement save(Movement Movement) throws Exception {
		return this.movementRepository.save(Movement);
	}

	public void delete(Long id) throws Exception {
		this.movementRepositoryImpl.delete(id);
	}

}
