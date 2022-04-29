package br.com.residencia.poo.contas;

import br.com.residencia.poo.exceptions.*;

public interface Transacao {
	void saca(double valor) throws ContaException;

	void deposita(double valor) throws ContaException;

	void transfere(Conta destino, double valor) throws ContaException;

}
