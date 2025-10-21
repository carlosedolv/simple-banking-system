package com.devteam.banco_agencias.entities.enums;

public enum SituacaoFuncionario {
	ATIVO(1),
	AFASTADO(2),
	FERIAS(3),
	DEMITIDO(4);
	
	private int code;
	
	private SituacaoFuncionario(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static SituacaoFuncionario valueOf(int code) {
		for(SituacaoFuncionario value : SituacaoFuncionario.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código Cargo inválido!");
	}
}
