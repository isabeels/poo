package br.com.residencia.poo.pessoas;

public class Usuario {

	/* ESSA CLASSE É IDENTICA A DE FUNCIONARIO, 
	 * NAO VEJO SENTIDO ESTA CLASSE USUARIO EXISTIR. */

	/* ATRIBUTOS */
	protected Integer idUsuario;
	protected String login;
	protected String senha;
	protected Double salario;

	/* CONSTRUTOR PARA INSTANCIAR NOVOS USUARIOS */
	public Usuario(Integer idUsuario, String login, String senha, Double salario) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.salario = salario;
	}

	/* GETTERS E SETTERS */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

}
