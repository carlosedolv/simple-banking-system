package com.devteam.banco_agencias.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devteam.banco_agencias.entities.Banco;
import com.devteam.banco_agencias.entities.enums.TipoInstituicao;
import com.devteam.banco_agencias.repositories.BancoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private BancoRepository bancoRepository;

	@Override
	public void run(String... args) throws Exception {

		Banco b1 = new Banco(null, "Banco Central", "00.000.000/0001-91", "001", "12345678", LocalDate.of(1965, 3, 31),
				TipoInstituicao.BANCO_COMERCIAL, "João Silva", "Rua das Finanças, 100", "Centro", "Brasília", "DF",
				"70000-000", "(61) 1234-5678", "contato@bancocentral.gov.br");

		Banco b2 = new Banco(null, "Banco do Brasil", "00.000.000/0002-91", "002", "87654321",
				LocalDate.of(1808, 10, 12), TipoInstituicao.BANCO_INVESTIMENTO, "Maria Oliveira",
				"Esplanada dos Ministérios, 200", "Centro", "Brasília", "DF", "70000-100", "(61) 2345-6789",
				"sac@bb.com.br");

		Banco b3 = new Banco(null, "Banco Itaú", "00.000.000/0003-91", "341", "11223344", LocalDate.of(1945, 5, 15),
				TipoInstituicao.BANCO_MULTIPLO, "Carlos Pereira", "Avenida Paulista, 500", "Bela Vista", "São Paulo",
				"SP", "01310-500", "(11) 3456-7890", "contato@itau.com.br");
		
		
		bancoRepository.saveAll(Arrays.asList(b1, b2, b3));
	}

}
