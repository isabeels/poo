package br.com.residencia.poo.contas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;

import br.com.residencia.poo.exceptions.CpfInvalidoException;
import br.com.residencia.poo.exceptions.OperacaoNaoAutorizadaException;
import br.com.residencia.poo.exceptions.SaldoInsuficienteException;
import br.com.residencia.poo.exceptions.ValorInvalidoException;

public class Conta {

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
		this.saldo = saldo;
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
	public void sacar(double valor)
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

	public void transferir(double valor, Conta destino) throws ValorInvalidoException, SaldoInsuficienteException, CpfInvalidoException, OperacaoNaoAutorizadaException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Impossível realizar transferência de valores negativos.");
		}
		else if (this.saldo < (valor + taxaTransferencia)) {
			throw new SaldoInsuficienteException();
		}
		else {
			sacar(valor + taxaTransferencia);
			destino.depositar(valor);
		}
	}
	
	public void exibirSaldo() {
		System.out.printf("Saldo atual e disponível: R$ %.2f", this.saldo);
	}
	
	public void relatorioTransacao(Conta conta, double valor, String cpfDestinatario) throws IOException {
        
		File diretorioRegistroTransacoes = new File ("C:\\RegistroTransacoesContas\\");
        File historicoConta = new File (diretorioRegistroTransacoes.getAbsolutePath() + "\\historicoTransacoes.txt");

        if (!diretorioRegistroTransacoes.exists()) {
        	diretorioRegistroTransacoes.mkdirs();  //cria um diretório
       }

        if(!historicoConta.exists()) {
        	historicoConta.createNewFile();  //cria um arquivo
        }

       try(FileWriter historicoContaWriter = new FileWriter(historicoConta, true);
            BufferedWriter historicoContaBuff = new BufferedWriter(historicoContaWriter)) {

    	   historicoContaBuff.append("aqui vai entrar o conta.get puxando os comprovantes");
  	      	   
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
