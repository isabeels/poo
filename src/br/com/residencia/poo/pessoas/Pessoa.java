package br.com.residencia.poo.pessoas;

import java.util.Date;

public class Pessoa {

	/* ATRIBUTOS */
	protected String nome;
	protected String cpf;
	protected String tipoPessoa;

	/* CONSTRUTOR PARA INSTANCIAR NOVAS PESSOAS */
	public Pessoa(String nome, String cpf, String tipoPessoa) {

		this.nome = nome;
		this.cpf = cpf;
		this.tipoPessoa = tipoPessoa;
	}
	
	public Pessoa() {
		
	}

	/* GETTERS E SETTERS */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}
