package com.t2s.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.t2s.web.model.Movement;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Long> {

	@Override
	@Query("select m FROM Movement m where m.isEnabled = true order by m.updatedAt desc")
	List<Movement> findAll();

	Optional<Movement> findByIdAndIsEnabled(Long id, Boolean isEnabled);

	@Query("select m FROM Movement m where m.isEnabled = true and m.container.id = :id order by m.updatedAt desc")
	List<Movement> findByContainerId(Long id);

}
