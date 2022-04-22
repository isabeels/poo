package br.com.residencia.poo.agencias;

public class Agencia {

	/* ATRIBUTOS */
	private Integer idAgencia;
	private String endereco;
	private Integer numeroAgencia;
	private Integer idGerente;
	private Integer idDiretor;

	/* CONSTRUTOR PARA INSTANCIAR NOVAS AGENCIAS */
	public Agencia(Integer idAgencia, String endereco, Integer numeroAgencia, Integer idGerente, Integer idDiretor) {
		super();
		this.idAgencia = idAgencia;
		this.endereco = endereco;
		this.numeroAgencia = numeroAgencia;
		this.idGerente = idGerente;
		this.idDiretor = idDiretor;
	}

	/* GETTERS E SETTERS */
	public Integer getIdAgencia() {
		return idAgencia;
	}

	public String getEndereco() {
		return endereco;
	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public Integer getIdGerente() {
		return idGerente;
	}

	public Integer getIdDiretor() {
		return idDiretor;
	}

}
