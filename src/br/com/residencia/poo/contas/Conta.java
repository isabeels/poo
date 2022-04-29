package br.com.residencia.poo.contas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import br.com.residencia.poo.exceptions.CpfInvalidoException;
import br.com.residencia.poo.exceptions.OperacaoNaoAutorizadaException;
import br.com.residencia.poo.exceptions.SaldoInsuficienteException;
import br.com.residencia.poo.exceptions.ValorInvalidoException;
import br.com.residencia.poo.pessoas.Pessoa;

public abstract class Conta {

	/* ATRIBUTOS */
	
	protected Pessoa cpfTitular;
	protected String numeroAgencia;
	protected String tipoConta;
	protected String numeroConta;
	protected Double saldo = 0.0;
	double taxaSaque = 0.10;
	double taxaDeposito = 0.10;
	double taxaTransferencia = 0.20;
	double totalTaxaSaque = 0;

	/* CONSTRUTOR PARA DIFERENTES TIPOS DE NOVAS CONTAS */
		
	public Conta(Pessoa cpfTitular, String numeroAgencia, String numeroConta) {
		this.cpfTitular = cpfTitular;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
	}
	
	/* GETTERS E SETTERS */

	public String getNumeroAgencia() {
		return numeroAgencia;
	}


	public String getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
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
	
	public double getTaxaSaque() {
		return taxaSaque;
	}

	public double getTaxaDeposito() {
		return taxaDeposito;
	}

	public double getTaxaTransferencia() {
		return taxaTransferencia;
	}

	public Pessoa getCpfTitular() {
		return cpfTitular;
	}
	
	public double getTotalTaxaSaque() {
		return totalTaxaSaque;
	}

	/* MÉTODOS DA CONTA - TUDO QUE UMA CONTA CORRENTE E POUPANCA PODE REALIZAR */
	public void sacar(Pessoa cpfTitular, double valor) throws ValorInvalidoException, SaldoInsuficienteException, IOException, OperacaoNaoAutorizadaException {
			if (valor <= 0) {
				throw new ValorInvalidoException();
			} else if (this.saldo < valor) {
				throw new SaldoInsuficienteException();
			} else {
				this.saldo -= valor;
				exibirSaldo();
				comprovanteSaque(cpfTitular,valor);
			
				this.totalTaxaSaque += taxaSaque;
				}
		} 

	public void depositar(double valor) throws ValorInvalidoException {
		if (valor < 0) {
			throw new ValorInvalidoException("Impossível depositar valores negativos.");
		} else {
			this.saldo += valor;
//			exibirSaldo();
		}

	}

	public void transferir(double valor, Conta destino) throws ValorInvalidoException, SaldoInsuficienteException, CpfInvalidoException, OperacaoNaoAutorizadaException, IOException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Impossível realizar transferência de valores negativos.");
		}
		else if (this.saldo < (valor)) {
			throw new SaldoInsuficienteException();
		}
		else {
			sacar(cpfTitular, valor);
			destino.depositar(valor);
			exibirSaldo();
		}
	}
	
	public void exibirSaldo() {
		System.out.printf("Saldo atual e disponível: R$ %.2f", this.saldo);
	}
	
	
	
	public void comprovanteSaque(Pessoa pessoa, double valor) throws IOException {
        
		File diretorioRegistroTransacoes = new File ("./temp/");
        File historicoConta = new File (diretorioRegistroTransacoes.getAbsolutePath() + "\\historicoSaques.txt");

        if (!diretorioRegistroTransacoes.exists()) {
        	diretorioRegistroTransacoes.mkdirs();  //cria um diretório
       }

        if(!historicoConta.exists()) {
        	historicoConta.createNewFile();  //cria um arquivo
        }

       try(FileWriter historicoContaWriter = new FileWriter(historicoConta, true);
            BufferedWriter historicoContaBuff = new BufferedWriter(historicoContaWriter)) {

    	   historicoContaBuff.append("¨¨¨¨¨¨¨¨¨¨COMPROVANTE DE SAQUE¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    	   historicoContaBuff.newLine();
    	   historicoContaBuff.newLine();
    	   historicoContaBuff.append(pessoa.getNome()+ "| CPF: " + pessoa.getCpf() + "| VALOR DO SAQUE: " + valor + ".");
    	   historicoContaBuff.newLine();
    	   historicoContaBuff.newLine();
    	   historicoContaBuff.append("Taxa de saque: R$ " + String.format("%.2f", taxaSaque));
    	   historicoContaBuff.newLine();
    	   historicoContaBuff.append("Total da tributação de taxas de saque: R$ " + String.format("%.2f", this.getTaxaSaque()));
    	   historicoContaBuff.newLine();
    	   historicoContaBuff.append("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    	   historicoContaBuff.newLine();
    	   historicoContaBuff.newLine();
    	   	   
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
   }

}
