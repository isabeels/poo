package br.com.residencia.poo.contas;

import br.com.residencia.poo.exceptions.ContaException;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String tipoConta, Integer numeroAgencia, Integer numeroConta, Double saldo, String cpf) {
		super(tipoConta, numeroAgencia, numeroConta, saldo, cpf);
	}

	@Override
	public void saca(double valor) throws ContaException {
		if (valor <= 0) {

			throw new ContaException("O valor digitado para saque é inválido!");

		} else {

			if (this.saldo > 0 && this.saldo >= valor) {

				this.saldo -= valor;

				// Usamos printf para limitar as casas decimais
				System.out.println("\nOperação realizada com sucesso!\n");
				System.out.printf("Valor sacado: R$%.2f%n", valor, "\n");
				System.out.printf("Saldo atual: R$%.2f%n", this.saldo, "\n");

				
			} else {
				System.out.println("Valor digitado excede o saldo disponível!");
			}

		}

	}

	@Override
	public void deposita(double valor) throws ContaException {
		if (valor < 0) {

			throw new ContaException("O valor digitado para depósito é inválido!");

		} else {

			this.saldo += valor;

			// Usamos printf para limitar as casas decimais
			System.out.println("\nOperação realizada com sucesso!\n");
			System.out.printf("Valor depositado: R$%.2f%n", valor, "\n");
			System.out.printf("Saldo atual: R$%.2f%n", this.saldo, "\n");
		}

	}

	@Override
	public void transfere(Conta destino, double valor) throws ContaException {

		if (valor < 0) {

			throw new ContaException("O valor digitado para transferência é inválido!");

		} else {

			if (this.saldo >= 0 && this.saldo >= valor) {

				this.saldo -= valor;
				destino.saldo += valor;

				// Usamos printf para limitar as casas decimais
				System.out.println("\nOperação realizada com sucesso!\n");
				System.out.println("--------------------------");
				System.out.println("Conta destinatária: ");
				System.out.printf("Agência: " + destino.getNumeroAgencia() + "\n");
				System.out.printf("Número: " + destino.getNumeroConta() + "\n");
				System.out.println("--------------------------");
				System.out.printf("Valor transferido: R$%.2f%n", valor, "\n");
				System.out.printf("Saldo atual: R$%.2f%n", this.saldo, "\n");
			} else {
				System.out.println("Valor digitado excede o saldo disponível!");
			}

		}

	}
	
	public void previsaoDeRendimento(Double valor, Integer dia) throws ContaException {
		double juros = 0.001;
		if (valor <= 0) {
            throw new ContaException("Não é possível simular com valores negativos.");
        }
		else if (dia <=0) {
			throw new ContaException("Não é possível simular com valores negativos.");
		}
		double rendimento = valor * (juros * dia);
		System.out.printf("A previsão resulta em: %.02 R$ em %d dias \n",rendimento, dia);
	}

	@Override
	public String toString() {
		return "Conta Poupança\tNúmero da Agência = " + this.numeroAgencia + "\tNúmero da Conta = "
				+ this.numeroConta + "\tSaldo = " + this.saldo + "\tCPF = " + this.cpf + "\n";
	}
}
