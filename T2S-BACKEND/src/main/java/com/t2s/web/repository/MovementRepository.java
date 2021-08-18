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
	@Query("select c FROM Movement c where c.isEnabled = true order by c.updatedAt desc")
	List<Movement> findAll();

	Optional<Movement> findByIdAndIsEnabled(Long id, Boolean isEnabled);

}
