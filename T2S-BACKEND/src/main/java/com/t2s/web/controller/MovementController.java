package com.t2s.web.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.t2s.web.model.Movement;
import com.t2s.web.service.MovementService;
import com.t2s.web.util.ServiceCommons;

@RestController
@RequestMapping("/movement")
public class MovementController {

	private final static Logger LOG = LoggerFactory.getLogger(MovementController.class);

	@Autowired
	private MovementService movementService;

	@Autowired
	private ServiceCommons serviceCommons;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<?>> findAll() {
		try {
			List<Movement> movements = this.movementService.findAll();
			return this.serviceCommons.createOkResponse(movements);
		} catch (Exception e) {
			LOG.error("Exception in MovementController, findAll()", e);
			return this.serviceCommons.createErrorResponse(null);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			Movement movement = this.movementService.findById(id);
			return this.serviceCommons.createOkResponse(movement);
		} catch (NoSuchElementException e) {
			LOG.error("Exception in MovementController, findById(Long id)", e);
			return this.serviceCommons.createErrorResponse("Não foi possível encontrar a movimentação requisitada");
		} catch (Exception e) {
			LOG.error("Exception in MovementController, findById(Long id)", e);
			return this.serviceCommons.createErrorResponse("Ocorreu um erro inesperado");
		}
	}

	@RequestMapping(value = "container/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findByContainerId(@PathVariable Long id) {
		try {
			List<Movement> movements = this.movementService.findByContainerId(id);
			return this.serviceCommons.createOkResponse(movements);
		} catch (NoSuchElementException e) {
			LOG.error("Exception in MovementController, findByContainerId(Long id)", e);
			return this.serviceCommons.createErrorResponse("Não foi possível encontrar as movimentações requisitada");
		} catch (Exception e) {
			LOG.error("Exception in MovementController, findByContainerId(Long id)", e);
			return this.serviceCommons.createErrorResponse("Ocorreu um erro inesperado");
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Movement Movement) {
		try {
			Movement result = this.movementService.save(Movement);
			return this.serviceCommons.createOkResponse(result);
		} catch (Exception e) {
			LOG.error("Exception in MovementController, save()", e);
			return this.serviceCommons.createErrorResponse("Ocorreu um problema ao salvar");
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<?> delete(@RequestParam("idMovement") Long idMovement) {
		try {
			this.movementService.delete(idMovement);
			return this.serviceCommons.createOkResponse("Excluído com sucesso");
		} catch (Exception e) {
			LOG.error("Exception in MovementController, delete()", e);
			return this.serviceCommons.createErrorResponse("Ocorreu um problema na exclusão");
		}
	}

}
