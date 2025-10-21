package com.devteam.banco_agencias.entities.enums;

public enum Cargo {
	PRESIDENTE(1),
	DIRETOR(2),
	GERENTE_GERAL(3),
	GERENTE_AGENCIA(4),
	ANALISTA(5),
	CAIXA(6),
	ATENDENTE(7),
	ESTAGIARIO(8);
	
	private int code;
	
	private Cargo(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Cargo valueOf(int code) {
		for(Cargo value : Cargo.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código Cargo inválido!");
	}
}
