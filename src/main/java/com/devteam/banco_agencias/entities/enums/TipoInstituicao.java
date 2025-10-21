package com.devteam.banco_agencias.entities.enums;

public enum TipoInstituicao {
	BANCO_COMERCIAL(1), 
	BANCO_INVESTIMENTO(2), 
	BANCO_MULTIPLO(3), 
	BANCO_DESENVOLVIMENTO(4), 
	COOPERATIVA_CREDITO(5);

	private int code;

	private TipoInstituicao(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TipoInstituicao valueOf(int code) {
		for (TipoInstituicao value : TipoInstituicao.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código TipoInstituicao inválido!");
	}
}
