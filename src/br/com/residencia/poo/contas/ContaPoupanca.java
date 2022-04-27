package br.com.residencia.poo.contas;

import java.io.IOException;

import br.com.residencia.poo.exceptions.CpfInvalidoException;
import br.com.residencia.poo.exceptions.OperacaoNaoAutorizadaException;
import br.com.residencia.poo.exceptions.SaldoInsuficienteException;
import br.com.residencia.poo.exceptions.ValorInvalidoException;

public class ContaPoupanca extends Conta {

	/* ATRIBUTOS */
	protected Integer idContaPoupanca;
	protected Double rendimento;

	/* CONSTRUTOR PARA INSTANCIAR NOVAS CONTAS POUPANCAS */
	public ContaPoupanca(Integer idConta, String numeroAgencia, String tipoConta, String numeroConta, Double saldo,
			Boolean status, String senha, Integer idContaPoupanca, Double rendimento) {
		super(idConta, numeroAgencia, tipoConta, numeroConta, saldo, status, senha);
		this.idContaPoupanca = idContaPoupanca;
		this.rendimento = rendimento;
	}

	/* GETTERS E SETTERS */
	public Integer getIdContaPoupanca() {
		return idContaPoupanca;
	}

	public void setIdContaPoupanca(Integer idContaPoupanca) {
		this.idContaPoupanca = idContaPoupanca;
	}

	public Double getRendimento() {
		return rendimento;
	}

	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}

	/* MÉTODO PARA A CONTA POUPANCA */

	public void calcularRendimentos() {

	}

	@Override
	public void sacar(Conta cpfTitular, double valor)
			throws ValorInvalidoException, SaldoInsuficienteException, OperacaoNaoAutorizadaException, IOException {
		super.sacar(cpfTitular, valor);
	}

	@Override
	public void depositar(double valor) throws ValorInvalidoException {
		super.depositar(valor);
	}

	@Override
	public void transferir(double valor, Conta destino) throws ValorInvalidoException, SaldoInsuficienteException,
			CpfInvalidoException, OperacaoNaoAutorizadaException, IOException {
		super.transferir(valor, destino);
	}

	
}
