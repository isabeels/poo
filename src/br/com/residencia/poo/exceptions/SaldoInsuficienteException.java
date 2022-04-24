package br.com.residencia.poo.exceptions;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException() {
		super("Saldo insuficiente!");
	}

	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}
}
