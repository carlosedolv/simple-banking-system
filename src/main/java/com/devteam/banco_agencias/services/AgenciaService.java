package com.devteam.banco_agencias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.devteam.banco_agencias.entities.Agencia;
import com.devteam.banco_agencias.repositories.AgenciaRepository;
import com.devteam.banco_agencias.services.exceptions.DatabaseException;
import com.devteam.banco_agencias.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository repository;

	public List<Agencia> findAll() {
		return repository.findAll();
	}

	public Agencia findById(Long id) {
		Optional<Agencia> agencia = repository.findById(id);
		return agencia.orElseThrow(() -> new ResourceNotFoundException(id));
	}


	public Agencia insert(Agencia agencia) {
		repository.save(agencia);
		return agencia;
	}

	public void delete(Long id) {
		try {
			repository.delete(findById(id));
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(id);
		}
	}

	public Agencia update(Long id, Agencia agencia) {
		try {
			Agencia reference = repository.getReferenceById(id);
			updateReference(reference, agencia);
			return repository.save(reference);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateReference(Agencia reference, Agencia agencia) {
		reference.setNome(agencia.getNome());
		reference.setCodigo(agencia.getCodigo());
		reference.setDataFundacao(agencia.getDataFundacao());
		reference.setSituacao(agencia.getSituacao());
		reference.setGerente(agencia.getGerente());
		reference.setEndereco(agencia.getEndereco());
		reference.setBairro(agencia.getBairro());
		reference.setCidade(agencia.getCidade());
		reference.setEstado(agencia.getEstado());
		reference.setCep(agencia.getCep());
		reference.setTelefone(agencia.getTelefone());
		reference.setEmail(agencia.getEmail());
		reference.setBanco(agencia.getBanco());
	}

}
