package br.com.residencia.poo.pessoas;

public class Gerente extends Funcionario {
	Integer idGerente;
	Integer numeroAgencia;
	
	public Integer getIdGerente() {
		return idGerente;
	}
	public void setIdGerente(Integer idGerente) {
		this.idGerente = idGerente;
	}
	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
//	@Override
//	public double getBonificacao() {
//		return super.getBonificacao()+(super.getBonificacao()*0.5);
//		//return this.salario * 0.15;
//	}
//
//	public Gerente(Double salario) {
//		super(salario);
//		
//	}
	
	

}
