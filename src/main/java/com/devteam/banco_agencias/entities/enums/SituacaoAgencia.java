package com.devteam.banco_agencias.entities.enums;

public enum SituacaoAgencia {
	ATIVA(1),
	DESATIVADA(2),
	EM_REFORMA(3),
	ENCERRADA(4);
	
	private int code;
	
	private SituacaoAgencia(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static SituacaoAgencia valueOf(int code) {
		for(SituacaoAgencia value : SituacaoAgencia.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código SituacaoAgencia inválido!");
	}
}
