package com.devteam.banco_agencias.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devteam.banco_agencias.entities.Agencia;
import com.devteam.banco_agencias.entities.Banco;
import com.devteam.banco_agencias.entities.enums.SituacaoAgencia;
import com.devteam.banco_agencias.entities.enums.TipoInstituicao;
import com.devteam.banco_agencias.repositories.AgenciaRepository;
import com.devteam.banco_agencias.repositories.BancoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private BancoRepository bancoRepository;

	@Autowired
	private AgenciaRepository agenciaRepository;

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

		Agencia a1 = new Agencia(null, "Agencia Norte", "383629", LocalDate.of(2003, 8, 21), SituacaoAgencia.ATIVA,
				"Carlos", "Rua X", "São Paulo", "São Paulo", "x", "carlos@gmail.com", "sa", "sa", b1);

		Agencia a2 = new Agencia(null, "Agencia Sul", "23454321", LocalDate.of(1989, 2, 18), SituacaoAgencia.DESATIVADA,
				"Carlos", "Rua Z", "São Paulo", "São Paulo", "SP", "carlos@gmail.com", "xxx", "ssaa", b1);
		
		Agencia a3 = new Agencia(null, "Agencia Noroeste", "383629", LocalDate.of(2013, 4, 8), SituacaoAgencia.EM_REFORMA,
				"Erika", "Rua Y", "São Paulo", "São Paulo", "SP", "carlos@gmail.com", "xxx", "ssaa", b3);
		
		Agencia a4 = new Agencia(null, "Agencia Leste", "4321443", LocalDate.of(2021, 4, 19), SituacaoAgencia.ATIVA,
				"Erika", "Rua A", "São Paulo", "São Paulo", "SP", "carlos@gmail.com", "xxx", "ssaa", b2);
		
		Agencia a5 = new Agencia(null, "Agencia Sul", "4930293102", LocalDate.of(2013, 4, 8), SituacaoAgencia.ENCERRADA,
				"João", "Rua A", "São Paulo", "São Paulo", "SP", "carlos@gmail.com", "xxx", "ssaa", b3);
		
		agenciaRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
	}

}
