package com.devteam.banco_agencias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.devteam.banco_agencias.entities.Banco;
import com.devteam.banco_agencias.repositories.BancoRepository;

@Service
public class BancoService {
	
	@Autowired
	private BancoRepository repository;
	
	public List<Banco> findAll() {
		return repository.findAll();
	}
	
	public Banco findById(Long id) {
		Optional<Banco> obj = repository.findById(id);
		return obj.get();
	}
	
	public Banco insert(Banco banco) {
		repository.save(banco);
		return banco;
	}
	
	public void delete(@PathVariable Long id) {
		repository.delete(findById(id));
	}
	
	public Banco update(Long id, Banco banco) {
		Banco reference = repository.getReferenceById(id);
		updateReference(reference, banco);
		return repository.save(reference);
	}
	
	private void updateReference(Banco reference, Banco banco) {
		reference.setNome(banco.getNome());
		reference.setCnpj(banco.getCnpj());
		reference.setCodigo(banco.getCodigo());
		reference.setIspb(banco.getIspb());
		reference.setDataFundacao(banco.getDataFundacao());
		reference.setTipoIntituicao(banco.getTipoIntituicao());
		reference.setPresidente(banco.getPresidente());
		reference.setEndereco(banco.getEndereco());
		reference.setBairro(banco.getBairro());
		reference.setCidade(banco.getCidade());
		reference.setEstado(banco.getEstado());
		reference.setCep(banco.getCep());
		reference.setTelefone(banco.getTelefone());
		reference.setEmail(banco.getEmail());
	}
	
}
