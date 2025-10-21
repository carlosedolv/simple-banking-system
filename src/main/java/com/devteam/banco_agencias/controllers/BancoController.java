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

import com.devteam.banco_agencias.entities.Banco;
import com.devteam.banco_agencias.services.BancoService;

@RestController
@RequestMapping(value = "/bancos")
public class BancoController {

	@Autowired
	private BancoService service;

	@GetMapping
	public ResponseEntity<List<Banco>> findAll() {
		List<Banco> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Banco> findById(@PathVariable Long id) {
		Banco obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Banco> insert(@RequestBody Banco banco) {
		Banco obj = service.insert(banco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Banco> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Banco> delete(@PathVariable Long id, @RequestBody Banco banco) {
		Banco entity = service.update(id, banco);
		return ResponseEntity.ok().body(entity);
	}
	

}
