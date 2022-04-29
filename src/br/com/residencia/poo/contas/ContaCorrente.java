package br.com.residencia.poo.contas;

import br.com.residencia.poo.exceptions.ContaException;
import br.com.residencia.poo.interfaces.Taxas;


public class ContaCorrente extends Conta implements Taxas {

	private Integer totalSaques = 0, totalDepositos = 0, totalTransferencias = 0;
	private Double totalTaxado = 0.0;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String tipoConta, Integer numeroAgencia, Integer numeroConta, Double saldo, String cpf) {
		super(tipoConta, numeroAgencia, numeroConta, saldo, cpf);
	}

	public Integer getTotalSaques() {
		return this.totalSaques;
	}

	public Integer getTotalDepositos() {
		return this.totalDepositos;
	}

	public Integer getTotalTransferencias() {
		return this.totalTransferencias;
	}

	public Double getTotalTributado() {
		return this.totalTaxado;
	}
	
	@Override
	public void saca(double valor) throws ContaException {
		
		if (valor < 0) {
			throw new ContaException("O valor digitado para saque é inválido!");
		} else {
			double valorTaxado = taxarSaque(valor);
			if (this.saldo - valorTaxado >= 0) {
				this.saldo -= valorTaxado;
				this.totalTaxado += Taxas.SAQUE;
				
				// Usamos printf para limitar as casas decimais
				System.out.println("\nOperação realizada com sucesso!\n");
				System.out.printf("Valor sacado: R$%.2f%n", valor, "\n");
				System.out.printf("Taxa para saque: R$%.2f%n", Taxas.SAQUE, "\n");
				System.out.printf("Saldo atual: R$%.2f%n", this.saldo, "\n");
				++totalSaques;
			} else {
				System.out.println("Valor digitado excede o saldo disponível!");
			}
		}
	}

	@Override
	public double taxarSaque(double valor) {
		return valor + Taxas.SAQUE;
	}
	
	@Override
	public void deposita(double valor) throws ContaException {
		if (valor < 0) {
			throw new ContaException("O valor digitado para depósito é inválido!");
		} else {
			double valorTaxado = taxarDeposito(valor);
			if (this.saldo - Taxas.DEPOSITO >= 0) {
				this.saldo += valorTaxado;
				this.totalTaxado += Taxas.DEPOSITO;

				// Usamos printf para limitar as casas decimais
				System.out.println("\nOperação realizada com sucesso!\n");
				System.out.printf("Valor depositado: R$%.2f%n", valor, "\n");
				System.out.printf("Taxa para depósito: R$%.2f%n", Taxas.DEPOSITO, "\n");
				System.out.printf("Saldo atual: R$%.2f%n", this.saldo, "\n");
				++totalDepositos;
			}
		}
	}

	@Override
	public double taxarDeposito(double valor) {
		return valor - Taxas.DEPOSITO;
	}
	
	@Override
	public void transfere(Conta destino, double valor) throws ContaException {
		if (valor <= 0) {
			throw new ContaException("O valor digitado para transferência é inválido!");

		} else {

			double valorTaxado = taxarTransferencia(valor);

			if (this.saldo - valorTaxado >= 0) {
				this.saldo -= valorTaxado;
				destino.saldo += valor;
				this.totalTaxado += Taxas.TRANSFERENCIA;

				// Usamos printf para limitar as casas decimais
				System.out.println("\nOperação realizada com sucesso!\n");
				System.out.println("--------------------------");
				System.out.println("Conta destinatária: ");
				System.out.printf("Agência: " + destino.getNumeroAgencia() + "\n");
				System.out.printf("Número: " + destino.getNumeroConta() + "\n");
				System.out.println("--------------------------");
				System.out.printf("Valor transferido: R$%.2f%n", valor, "\n");
				System.out.printf("Taxa para transferência: R$%.2f%n", Taxas.TRANSFERENCIA, "\n");
				System.out.printf("Saldo atual: R$%.2f%n", this.saldo, "\n");
				
				++totalTransferencias;
			} else {
				System.out.println("Valor digitado excede o saldo disponível!");
			}

		}

	}
	
	@Override
	public double taxarTransferencia(double valor) {
		return valor + Taxas.TRANSFERENCIA;
	}
	
	@Override
	public String toString() {
		return "Conta Corrente\tNúmero da Agência = " + this.numeroAgencia + "\tNúmero da Conta = "
				+ this.numeroConta + "\tSaldo = " + this.saldo + "\tCPF = " + this.cpf + "\n";
	}

}

