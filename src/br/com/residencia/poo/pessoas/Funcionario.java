package br.com.residencia.poo.pessoas;

import java.util.Date;

public class Funcionario extends Pessoa {

	/* ATRIBUTOS */
	protected Integer idFuncionario;
	protected String login;
	protected String senha;
	protected Double salario;
	protected String cargo;

	/* CONSTRUTOR PARA INSTANCIAR NOVOS FUNCIONÁRIOS INVOCANDO SUPERCLASSE PESSOA */
	public Funcionario(String nome, String genero, String estadoCivil, String cpf, String telefone, String endereco,
			String email, Date dataNascimento, String tipoPessoa, Integer idFuncionario, String login, String senha,
			Double salario, String cargo) {

		super(nome, genero, estadoCivil, cpf, telefone, endereco, email, dataNascimento, tipoPessoa);

		this.idFuncionario = idFuncionario;
		this.login = login;
		this.senha = senha;
		this.salario = salario;
		this.cargo = cargo;
	}

	/* GETTERS E SETTERS */
	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
