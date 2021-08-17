package com.t2s.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2s.web.model.Container;
import com.t2s.web.service.ContainerService;
import com.t2s.web.util.ServiceCommons;

@RestController
@RequestMapping("/container")
public class ContainerController {

	private final static Logger LOG = LoggerFactory.getLogger(ContainerController.class);

	@Autowired
	private ContainerService containerService;

	@Autowired
	private ServiceCommons serviceCommons;

	@RequestMapping(value = "/")
	public ResponseEntity<List<Container>> findAll() {
		try {
			List<Container> containers = this.containerService.findAll();
			return this.serviceCommons.createOkResponse(containers);
		} catch (Exception e) {
			LOG.error("Exception in ContainerController, findAll()", e);
			return this.serviceCommons.createErrorResponse(null);
		}
	}

}
