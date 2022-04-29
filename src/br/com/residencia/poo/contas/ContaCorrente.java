package br.com.residencia.poo.contas;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import br.com.residencia.poo.enums.TipoConta;
import br.com.residencia.poo.exceptions.CpfInvalidoException;
import br.com.residencia.poo.exceptions.OperacaoNaoAutorizadaException;
import br.com.residencia.poo.exceptions.SaldoInsuficienteException;
import br.com.residencia.poo.exceptions.ValorInvalidoException;
import br.com.residencia.poo.pessoas.Pessoa;

public class ContaCorrente extends Conta {

	/* ATRIBUTOS */
	protected static Integer idContaCorrente= 0;
	protected  Integer SingleidContaCorrente= 0;
	protected LocalDate dataAbertura;
	private static final TipoConta tipoCC = TipoConta.CORRENTE;
	static List<ContaCorrente> cCC = new ArrayList<ContaCorrente>();

	/* CONSTRUTOR PARA INSTANCIAR NOVAS CONTAS CORRENTES */
	
	public ContaCorrente(Pessoa cpfTitular, String numeroAgencia, String numeroConta) {
		super(cpfTitular, numeroAgencia, numeroConta);
		incrementarID();
		getTipocc();
		dataAbertura = LocalDate.now();
	}
	
	public void setList(List<ContaCorrente> Contas) {
		ContaCorrente.cCC = Contas;
	}
	public void addList(ContaCorrente conta) {
		ContaCorrente.cCC.add(conta);
	}
	
	/* GETTERS E SETTERS */
	public Integer getIdContaCorrente() {
		return SingleidContaCorrente;
	}
	
	public static TipoConta getTipocc() {
		return tipoCC;
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
	/* METODOS */
	
	public Integer incrementarID() {
		this.SingleidContaCorrente++;
		return idContaCorrente++;
	}
	
	@Override
	public void sacar(Pessoa conta, double valor)
			throws ValorInvalidoException, SaldoInsuficienteException, OperacaoNaoAutorizadaException, IOException {
		super.sacar(cpfTitular, valor + this.getTaxaSaque());
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

	@Override
	public String toString() {
		return "[ Conta Corrente ID: " + idContaCorrente + " | CPF do titular: " + this.cpfTitular.getCpf() + " | Número da agência: "
				+ numeroAgencia + " | Tipo de conta: " + getTipocc() + " | Número da Conta: " + numeroConta + " | Data de abertura: "
				+ dataAbertura + " | Saldo atual: " + saldo + " R$ ]";
	}
	
	
}
