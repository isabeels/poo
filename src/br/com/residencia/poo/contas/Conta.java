package br.com.residencia.poo.contas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import br.com.residencia.poo.exceptions.CpfInvalidoException;
import br.com.residencia.poo.exceptions.OperacaoNaoAutorizadaException;
import br.com.residencia.poo.exceptions.SaldoInsuficienteException;
import br.com.residencia.poo.exceptions.ValorInvalidoException;
import br.com.residencia.poo.pessoas.Pessoa;

public class Conta {

	/* ATRIBUTOS */
	
	protected Pessoa cpfTitular;
	private Integer idConta;
	private String numeroAgencia;
	private String tipoConta;
	private String numeroConta;
	private Double saldo;
	private LocalDate dataAbertura;
	private Boolean status;
	private String senha;
	double taxaSaque = 0.10;
	double taxaDeposito = 0.10;
	double taxaTransferencia = 0.20;
	double totalTaxaSaque = 0;

	/* CONSTRUTOR PARA DIFERENTES TIPOS DE NOVAS CONTAS */
	
//	private static int totalDeContas = 0;
//	
//	public Conta() {
//		 Conta.totalDeContas = Conta.totalDeContas + 1;
//	}
//	public void imprimirConta() {
//		System.out.println(this.totalDeContas);
//	}
//	public int getNumeroContas() {
//		return totalDeContas;
//	}
	

	public Conta(Integer idConta, String numeroAgencia, String tipoConta, String numeroConta, Double saldo,
			Boolean status, String senha) {
		this.idConta = idConta;
		this.numeroAgencia = numeroAgencia;
		this.tipoConta = tipoConta;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.status = status;
		this.senha = senha;
		this.dataAbertura = LocalDate.now();
		//Conta.totalDeContas = Conta.totalDeContas + 1;
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
	public void sacar(Pessoa cpfTitular, double valor)
			throws ValorInvalidoException, SaldoInsuficienteException, OperacaoNaoAutorizadaException, IOException {

		if (Boolean.TRUE.equals(status)) {
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
		} else {
			throw new OperacaoNaoAutorizadaException("Impossível sacar de uma conta fechada.");
		}
	}

	public void depositar(double valor) throws ValorInvalidoException {
		if (valor < 0) {
			throw new ValorInvalidoException("Impossível depositar valores negativos.");
		} else {
			this.saldo += valor;
			exibirSaldo();
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
	
	/* OVERRIDES */
	@Override
	public String toString() {
		return "Número da agência: " + numeroAgencia + "\n" + "Tipo da conta: " + tipoConta + "\n" + "Número da conta: "
				+ numeroConta + "\n" + "Saldo da conta: " + saldo + "\n" + "Data de abertura: " + dataAbertura
				+ "\n" + "Status da conta: " + status + "\n";
	}
}
