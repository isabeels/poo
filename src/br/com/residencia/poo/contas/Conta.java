package br.com.residencia.poo.contas;
//teste
import java.text.NumberFormat;
import java.time.LocalDate;

public class Conta {
	private Integer idConta;
	private String numeroAgencia;
	private String tipoConta;
	private String numeroConta;
	private Double saldo;
	private String saldoFormatado;
	private LocalDate dataAbertura;
	private Boolean status;
	private String senha;
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	
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

	@Override
	public String toString() {
		return "Número da agência: " + numeroAgencia + "\n" + "Tipo da conta: " + tipoConta + "\n" + "Número da conta: "
				+ numeroConta + "\n" + "Saldo da conta: " + saldoFormatado + "\n" + "Data de abertura: " + dataAbertura
				+ "\n" + "Status da conta: " + status + "\n";
	}
}
