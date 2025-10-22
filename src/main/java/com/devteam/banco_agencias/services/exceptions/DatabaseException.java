package com.devteam.banco_agencias.services.exceptions;

public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(Object id) {
		super("Violação de restrição de integridade referencial. Id: " + id);
	}

}
