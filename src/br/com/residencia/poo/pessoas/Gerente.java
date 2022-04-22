package br.com.residencia.poo.pessoas;

import java.util.Date;

public class Gerente extends Funcionario {

	/* ATRIBUTOS */
	protected Integer idGerente;
	protected Integer numeroAgencia;

	/*CONSTRUTOR PARA INSTANCIAR NOVOS GERENTES INVOCANDO SUPERCLASSE FUNCIONARIO*/
	public Gerente(String nome, String genero, String estadoCivil, String cpf, String telefone, String endereco,
			String email, Date dataNascimento, String tipoPessoa, Integer idFuncionario, String login, String senha,
			Double salario, String cargo, Integer idGerente, Integer numeroAgencia) {

		super(nome, genero, estadoCivil, cpf, telefone, endereco, email, dataNascimento, tipoPessoa, idFuncionario,
				login, senha, salario, cargo);

		this.idGerente = idGerente;
		this.numeroAgencia = numeroAgencia;
	}

	/* GETTERS E SETTERS */
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

	/* MÉTODOS DA CLASSE GERENTE */
	
	public void emitirRelatorioContas() {

		/*
		 * Aqui poderia entrar um metódo de controle das contas administradas pelo
		 * gerente na agencia que ele trabalha. Ex: quantidade de contas correntes e
		 * poupança que ele é responsável, quantidade de clientes dele, etc.
		 */
	}
}
