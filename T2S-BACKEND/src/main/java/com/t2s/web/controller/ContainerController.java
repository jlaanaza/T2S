package com.t2s.web.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<?>> findAll() {
		try {
			List<Container> containers = this.containerService.findAll();
			return this.serviceCommons.createOkResponse(containers);
		} catch (Exception e) {
			LOG.error("Exception in ContainerController, findAll()", e);
			return this.serviceCommons.createErrorResponse(null);
		}
	}

	@RequestMapping(value = "/{containerNumber}", method = RequestMethod.GET)
	public ResponseEntity<?> findByContainerNumber(@PathVariable String containerNumber) {
		try {
			Container container = this.containerService.findByContainerNumber(containerNumber);
			return this.serviceCommons.createOkResponse(container);
		} catch (NoSuchElementException e) {
			LOG.error("Exception in ContainerController, findByContainerNumber(String containerNumber)", e);
			return this.serviceCommons.createErrorResponse("Não foi possível encontrar o container requisitado");
		} catch (Exception e) {
			LOG.error("Exception in ContainerController, findByContainerNumber(String containerNumber)", e);
			return this.serviceCommons.createErrorResponse("Ocorreu um erro inesperado");
		}
	}

	@CrossOrigin
	@RequestMapping(value = "/update/save", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Container container) {
		try {
			Container result = this.containerService.save(container);
			return this.serviceCommons.createOkResponse(result);
		} catch (Exception e) {
			LOG.error("Exception in ContainerController, save()", e);
			return this.serviceCommons.createErrorResponse("Ocorreu um problema ao salvar");
		}
	}

	@RequestMapping(value = "/update/delete", method = RequestMethod.POST)
	public ResponseEntity<?> delete(@RequestParam("idContainer") Long idContainer) {
		try {
			this.containerService.delete(idContainer);
			return this.serviceCommons.createOkResponse("Excluído com sucesso");
		} catch (Exception e) {
			LOG.error("Exception in ContainerController, delete()", e);
			return this.serviceCommons.createErrorResponse("Ocorreu um problema na exclusão");
		}
	}

}
