package br.com.residencia.poo.exceptions;

public class SenhaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public SenhaInvalidaException() {
		super("Senha inválida!");
	}

	public SenhaInvalidaException(String mensagem) {
		super(mensagem);
	}
}
