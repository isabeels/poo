package br.com.residencia.poo.contas;

public class ContaPoupanca extends Conta {

	/* ATRIBUTOS */
	protected Integer idContaPoupanca;
	protected Double rendimento;

	/* CONSTRUTOR PARA INSTANCIAR NOVAS CONTAS POUPANCAS */
	public ContaPoupanca(Integer idConta, String numeroAgencia, String tipoConta, String numeroConta, Double saldo,
			Boolean status, String senha, Integer idContaPoupanca, Double rendimento) {
		super(idConta, numeroAgencia, tipoConta, numeroConta, saldo, status, senha);
		this.idContaPoupanca = idContaPoupanca;
		this.rendimento = rendimento;
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

	/* MÉTODO PARA A CONTA POUPANCA */

	public void calcularRendimentos() {

	}

}
