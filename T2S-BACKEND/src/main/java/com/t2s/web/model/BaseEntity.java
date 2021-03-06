package com.t2s.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty(value = "createdAt")
	@Column(name = "created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty(value = "updatedAt")
	@Column(name = "updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
	private Date updatedAt;

	@JsonProperty(value = "isEnabled")
	@Column(name = "is_enabled", columnDefinition = "bit(1) not null default 1")
	private Boolean isEnabled = true;

	@PrePersist
	public void prePersist() {
		Date date = new Date();
		createdAt = date;
		updatedAt = date;
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = new Date();
	}

}
