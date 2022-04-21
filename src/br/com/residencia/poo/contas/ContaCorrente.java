package br.com.residencia.poo.contas;


public class ContaCorrente {
	Integer idContaCorrente;
	Double chequeEspecial;
	Double taxa;
	
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
	
}
