package com.t2s.web.model;


import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends BaseEntity {
	
	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "cpf", length = 14)
	private String cpf;
	
	@Column(name = "phone", length= 14)
	private String phone;
	
}
