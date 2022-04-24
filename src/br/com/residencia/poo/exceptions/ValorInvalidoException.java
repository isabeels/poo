package br.com.residencia.poo.exceptions;

public class ValorInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValorInvalidoException() {
		super("O valor digitado é inválido!");
	}

	public ValorInvalidoException(String mensagem) {
		super(mensagem);
	}

}
