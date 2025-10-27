package com.devteam.banco_agencias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devteam.banco_agencias.entities.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

}
