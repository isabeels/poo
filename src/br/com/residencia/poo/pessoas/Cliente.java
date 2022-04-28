package br.com.residencia.poo.pessoas;

import java.util.Date;

public class Cliente extends Pessoa {

	/* ATRIBUTOS */
	protected String idCliente;
	protected String idGerente;

	/* CONSTRUTOR PARA INSTANCIAR NOVOS CLIENTES INVOCANDO A SUPERCLASSE PESSOA */
	public Cliente(String nome, String cpf, String tipoPessoa,String idCliente,String idGerente) {
		super(nome,cpf, tipoPessoa);
		this.idCliente = idCliente;
		this.idGerente = idGerente;
	}

	/* GETTERS E SETTERS */
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(String idGerente) {
		this.idGerente = idGerente;
	}

}
