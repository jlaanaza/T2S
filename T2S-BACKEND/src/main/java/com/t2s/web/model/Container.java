package com.t2s.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.t2s.web.enumeration.CategoryEN;
import com.t2s.web.enumeration.StatusEN;
import com.t2s.web.enumeration.TypeEN;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "container")
public class Container extends BaseEntity {

	@Column(name = "client", length = 50)
	private String client;

	@Column(name = "containerNumber", length = 11)
	private String containerNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TypeEN type;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private StatusEN status;

	@Enumerated(EnumType.STRING)
	@Column(name = "category", nullable = false)
	private CategoryEN category;

}
