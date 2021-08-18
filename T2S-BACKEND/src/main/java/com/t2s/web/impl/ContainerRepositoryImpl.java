package com.t2s.web.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.t2s.web.repository.custom.ContainerRepositoryCustom;

@Repository
public class ContainerRepositoryImpl implements ContainerRepositoryCustom {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void delete(Long id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE ");
		sb.append(" Container ");
		sb.append(" set isEnabled = false,");
		sb.append(" updatedAt = :date ");
		sb.append(" WHERE id = :id ");
		Query query = this.getEntityManager().createQuery(sb.toString());
		query.setParameter("id", id);
		query.setParameter("date", new Date());
		query.executeUpdate();
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
