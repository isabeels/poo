package br.com.residencia.poo.contas;

import java.text.NumberFormat;
import java.time.LocalDate;

import br.com.residencia.poo.exceptions.CpfInvalidoException;
import br.com.residencia.poo.exceptions.OperacaoNaoAutorizadaException;
import br.com.residencia.poo.exceptions.SaldoInsuficienteException;
import br.com.residencia.poo.exceptions.ValorInvalidoException;

public abstract class Conta {

	/* ATRIBUTOS */
	private Integer idConta;
	private String numeroAgencia;
	private String cpfTitular;
	private String tipoConta;
	private String numeroConta;
	private Double saldo;
	private String saldoFormatado;
	private LocalDate dataAbertura;
	private Boolean status;
	private String senha;
	NumberFormat nf = NumberFormat.getCurrencyInstance();

	static final double taxaSaque = 0.10;
	static final double taxaDeposito = 0.10;
	static final double taxaTransferencia = 0.20;

	/* CONSTRUTOR PARA INSTANCIAR NOVAS CONTAS */

	public Conta() {

	}

	public Conta(Integer idConta, String numeroAgencia, String tipoConta, String numeroConta, Double saldo,
			Boolean status, String senha) {
		this.idConta = idConta;
		this.numeroAgencia = numeroAgencia;
		this.tipoConta = tipoConta;
		this.numeroConta = numeroConta;
		this.saldoFormatado = nf.format(saldo);
		this.status = status;
		this.senha = senha;
		this.dataAbertura = LocalDate.now();
	}

	/* GETTERS E SETTERS */
	public Integer getIdConta() {
		return idConta;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getSaldoFormatado() {
		return saldoFormatado;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public Boolean getStatus() {
		return status;
	}

	public String getSenha() {
		return senha;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/* MÉTODOS DA CONTA - TUDO QUE UMA CONTA CORRENTE E POUPANCA PODE REALIZAR */
	public void saque(double valor)
			throws ValorInvalidoException, SaldoInsuficienteException, OperacaoNaoAutorizadaException {

		if (status) {
			if (valor <= 0) {
				throw new ValorInvalidoException();
			} else if (this.saldo < (valor + taxaSaque)) {
				throw new SaldoInsuficienteException();
			} else {
				this.saldo -= (valor + taxaSaque);
			}
		} else {
			throw new OperacaoNaoAutorizadaException("Impossível sacar de uma conta fechada.");
		}
	}

	public void depositar(double valor) throws ValorInvalidoException {
		if (valor <= taxaDeposito) {
			throw new ValorInvalidoException("Impossível depositar valores negativos.");
		} else {
			this.saldo += (valor - taxaDeposito);
		}

	}

	public void transferencia(double valor, String cpfTitular, String destino) throws ValorInvalidoException, SaldoInsuficienteException, CpfInvalidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Impossível realizar transferência de valores negativos.");
		}
		else if (this.saldo < (valor + taxaTransferencia)) {
			throw new SaldoInsuficienteException();
		}
		else {
			this.saldo -= (valor + taxaTransferencia);
		}
	}
	public void exibirSaldo() {
		System.out.printf("Saldo atual e disponível: R$ %.2f", this.saldo);
	}

	/* OVERRIDES */
	@Override
	public String toString() {
		return "Número da agência: " + numeroAgencia + "\n" + "Tipo da conta: " + tipoConta + "\n" + "Número da conta: "
				+ numeroConta + "\n" + "Saldo da conta: " + saldoFormatado + "\n" + "Data de abertura: " + dataAbertura
				+ "\n" + "Status da conta: " + status + "\n";
	}
}
