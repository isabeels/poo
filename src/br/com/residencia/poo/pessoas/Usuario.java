package br.com.residencia.poo.pessoas;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Usuario implements Comparable<Usuario> {

	protected String tipoUsuario;
	protected String nome;
	protected String cpf;
	protected String senha;
	protected Integer agencia;
	protected Integer numeroDaConta;

	public static Map<String, Usuario> mapaUsuarios = new HashMap<>();
	public static TreeMap<String, Usuario> OrdenaUsuarios = new TreeMap<>();

	public Usuario() {

	}

	public Usuario(String tipoUsuario, String nome, String cpf, String senha, Integer agencia, Integer numeroDaConta) {
		this.nome = nome;
		this.tipoUsuario = tipoUsuario;
		this.cpf = cpf;
		this.senha = senha;
		this.agencia = agencia;
		this.numeroDaConta = numeroDaConta;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		// só vai registrar o cpf no campo se o campo estiver vazio, sem nada
		if (this.cpf == null) {
			this.cpf = cpf;
		}
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getAgencia() {
		return this.agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumeroConta() {
		return this.numeroDaConta;
	}

	public void setNumeroConta(Integer numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	@Override
	public int compareTo(Usuario outroUsuario) {

		return this.nome.compareTo(outroUsuario.getNome());
	}

	public String relatorioInformacoes() {

		return "Nome: " + this.nome + "\t CPF: " + this.cpf + "\tAgencia: " + this.agencia;

	}

	@Override
	public String toString() {
		return "Usuario [nome=" + this.nome + ", tipoUsuario=" + this.tipoUsuario + ", cpf=" + this.cpf + ", senha="
				+ this.senha + ", agencia=" + this.agencia + ", numeroConta=" + this.numeroDaConta + "]";
	}

}
