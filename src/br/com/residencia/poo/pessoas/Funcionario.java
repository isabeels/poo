package br.com.residencia.poo.pessoas;

public class Funcionario extends Pessoa {
	Integer idFuncionario;
	String login;
	String senha;
	Double salario;
	String cargo;
	
	public Funcionario() {
		
	}
	
//	public Funcionario(Double salario) {
//		super();
//		this.salario = salario;
//	}

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
