package br.com.residencia.poo.interfaces;

public interface Taxas {
	
		double SAQUE = 0.1d, DEPOSITO = 0.1d, TRANSFERENCIA = 0.2d;

		double taxarSaque(double valor);
		double taxarDeposito(double valor);
		double taxarTransferencia(double valor);
}
