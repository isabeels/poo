package br.com.residencia.poo.exceptions;

public class CpfInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public CpfInvalidoException() {
		super("Número de CPF inválido!");
	}

	public CpfInvalidoException(String message) {
		super(message);
	}
}
