package br.com.residencia.poo.exceptions;

public class LoginInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginInvalidoException() {
		super("Login inexistente.");
	}

	public LoginInvalidoException(String mensagem) {
		super(mensagem);
	}
}
