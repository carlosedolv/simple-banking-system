package com.devteam.banco_agencias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devteam.banco_agencias.entities.Agencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

}
