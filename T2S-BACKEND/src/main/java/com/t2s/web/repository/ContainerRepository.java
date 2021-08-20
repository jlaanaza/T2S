package com.t2s.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.t2s.web.model.Container;

@Repository
public interface ContainerRepository extends CrudRepository<Container, Long> {

	@Override
	@Query("select c FROM Container c where c.isEnabled = true order by c.updatedAt desc")
	List<Container> findAll();

	Optional<Container> findByContainerNumberAndIsEnabled(String containerNumber, Boolean isEnabled);

}
