package com.devteam.banco_agencias.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devteam.banco_agencias.entities.Agencia;
import com.devteam.banco_agencias.services.AgenciaService;

@RestController
@RequestMapping(value = "/agencias")
public class AgenciaController {

	@Autowired
	private AgenciaService service;

	@GetMapping
	public ResponseEntity<List<Agencia>> findAll() {
		List<Agencia> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Agencia> findById(@PathVariable Long id) {
		Agencia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Agencia> insert(@RequestBody Agencia agencia) {
		Agencia obj = service.insert(agencia);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Agencia> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Agencia> update(@PathVariable Long id, @RequestBody Agencia agencia) {
		Agencia obj = service.update(id, agencia);
		return ResponseEntity.ok().body(obj);
	}
}
