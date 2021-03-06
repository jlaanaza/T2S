package com.t2s.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.t2s.web.enumeration.MovementTypeEN;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movement")
public class Movement extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "movementType")
	@Column(name = "movement_type", nullable = false)
	private MovementTypeEN movementType;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty(value = "startDate")
	@Column(name = "start_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty(value = "endDate")
	@Column(name = "end_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
	private Date endDate;

	@JsonProperty(value = "container")
	@ManyToOne
	@JoinColumn(name = "container_id")
	private Container container;

}
