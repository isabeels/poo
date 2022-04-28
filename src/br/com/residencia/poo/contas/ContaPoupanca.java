package br.com.residencia.poo.contas;

import java.io.IOException;
import java.time.LocalDate;
import br.com.residencia.poo.enums.TipoConta;
import br.com.residencia.poo.exceptions.CpfInvalidoException;
import br.com.residencia.poo.exceptions.OperacaoNaoAutorizadaException;
import br.com.residencia.poo.exceptions.SaldoInsuficienteException;
import br.com.residencia.poo.exceptions.ValorInvalidoException;
import br.com.residencia.poo.pessoas.Pessoa;

public class ContaPoupanca extends Conta {

	/* ATRIBUTOS */
	protected Integer idContaPoupanca;
	protected LocalDate dataAbertura;
	protected Double rendimento;
	private static final TipoConta tipoCP = TipoConta.POUPANCA;

	/* CONSTRUTOR PARA INSTANCIAR NOVAS CONTAS POUPANCAS */
	
	public ContaPoupanca(Integer idContaPoupanca, Pessoa cpfTitular, String numeroAgencia, String numeroConta,
			LocalDate dataAbertura) {
		super(cpfTitular, numeroAgencia, numeroConta);
		this.idContaPoupanca = idContaPoupanca;
		this.dataAbertura = LocalDate.now();
		getTipocp();
		getSaldo();
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
	
	public static TipoConta getTipocp() {
		return tipoCP;
	}


	/* MÉTODO PARA A CONTA POUPANCA */

	public void calcularRendimentos() {

	}

	@Override
	public void sacar(Pessoa cpfTitular, double valor)
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

	@Override
	public String toString() {
		return "ContaPoupanca [idContaPoupanca=" + idContaPoupanca + ", cpfTitular=" + cpfTitular + ", numeroAgencia="
				+ numeroAgencia + ", tipoConta=" + tipoConta + ", numeroConta=" + numeroConta + ", dataAbertura="
				+ dataAbertura + "]";
	}

}
