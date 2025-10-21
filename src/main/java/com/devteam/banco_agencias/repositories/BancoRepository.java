package com.devteam.banco_agencias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devteam.banco_agencias.entities.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long>{

}
