package br.com.residencia.poo.contas;

import java.io.IOException;

import br.com.residencia.poo.exceptions.CpfInvalidoException;
import br.com.residencia.poo.exceptions.OperacaoNaoAutorizadaException;
import br.com.residencia.poo.exceptions.SaldoInsuficienteException;
import br.com.residencia.poo.exceptions.ValorInvalidoException;

public class ContaCorrente extends Conta {

	/* ATRIBUTOS */
	protected Integer idContaCorrente;
	protected Double chequeEspecial;
	protected Double taxa;

	/* CONSTRUTOR PARA INSTANCIAR NOVAS CONTAS CORRENTES */
	public ContaCorrente(Integer idConta, String numeroAgencia, String tipoConta, String numeroConta, Double saldo,
			Boolean status, String senha, Integer idContaCorrente, Double chequeEspecial, Double taxa) {
		super(idConta, numeroAgencia, tipoConta, numeroConta, saldo, status, senha);
		this.idContaCorrente = idContaCorrente;
		this.chequeEspecial = chequeEspecial;
		this.taxa = taxa;
	}

	/* GETTERS E SETTERS */
	public Integer getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(Integer idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

	public Double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(Double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	@Override
	public double getTaxaSaque() {
		return super.getTaxaSaque();
	}

	@Override
	public double getTaxaDeposito() {
		return super.getTaxaDeposito();
	}

	@Override
	public double getTaxaTransferencia() {
		return super.getTaxaTransferencia();
	}

	@Override
	public void sacar(Pessoa conta, double valor)
			throws ValorInvalidoException, SaldoInsuficienteException, OperacaoNaoAutorizadaException, IOException {
		super.sacar(valor + this.getTaxaSaque());
	}

	@Override
	public void depositar(double valor) throws ValorInvalidoException {
		super.depositar(valor - this.getTaxaDeposito());
	}

	@Override
	public void transferir(double valor, Conta destino) throws ValorInvalidoException, SaldoInsuficienteException,
			CpfInvalidoException, OperacaoNaoAutorizadaException, IOException {
		super.transferir(valor + this.getTaxaTransferencia(), destino);
	}

	@Override
	public void exibirSaldo() {
		super.exibirSaldo();
	}
}

	/* MÉTODOS DE UMA CONTA CORRENTE */


