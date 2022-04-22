package br.com.residencia.poo.pessoas;

import java.util.Date;

public class Cliente extends Pessoa {

	/* ATRIBUTOS */
	protected Integer idCliente;
	protected Integer idGerente;

	/* CONSTRUTOR PARA INSTANCIAR NOVOS CLIENTES INVOCANDO A SUPERCLASSE PESSOA */
	public Cliente(String nome, String genero, String estadoCivil, String cpf, String telefone, String endereco,
			String email, Date dataNascimento, String tipoPessoa, Integer idCliente, Integer idGerente) {
		super(nome, genero, estadoCivil, cpf, telefone, endereco, email, dataNascimento, tipoPessoa);
		this.idCliente = idCliente;
		this.idGerente = idGerente;
	}

	/* GETTERS E SETTERS */
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(Integer idGerente) {
		this.idGerente = idGerente;
	}

}
