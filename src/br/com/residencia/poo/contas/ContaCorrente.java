package br.com.residencia.poo.contas;

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

	/* MÉTODOS DE UMA CONTA CORRENTE */

	public void pagarTaxa() {

	}

	public void pagarChequeEspecial() {

	}

}
