package br.com.residencia.poo.exceptions;

public class ContaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public ContaInvalidaException() {
		super("A conta fornecida é inválida!");
	}

	public ContaInvalidaException(String mensagem) {
		super(mensagem);
	}
}
