package br.com.residencia.poo.pessoas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Presidente extends Funcionario {

	/* ATRIBUTOS */
	protected Integer idPresidente;
	protected List<Diretor> diretores = new ArrayList<>();

	/* CONSTRUTOR PARA INSTANCIAR NOVOS PRESIDENTES INVOCANDO SUPERCLASSE FUNCIONARIO*/
	public Presidente(String nome, String genero, String estadoCivil, String cpf, String telefone, String endereco,
			String email, Date dataNascimento, String tipoPessoa, Integer idFuncionario, String login, String senha,
			Double salario, String cargo, Integer idPresidente, List<Diretor> diretores) {
		super(nome, genero, estadoCivil, cpf, telefone, endereco, email, dataNascimento, tipoPessoa, idFuncionario,
				login, senha, salario, cargo);
		this.idPresidente = idPresidente;
		this.diretores = diretores;
	}

	/* GETTERS E SETTERS */
	public Integer getIdPresidente() {
		return idPresidente;
	}

	public void setIdPresidente(Integer idPresidente) {
		this.idPresidente = idPresidente;
	}

	public List<Diretor> getDiretores() {
		return diretores;
	}

	public void setDiretores(List<Diretor> diretores) {
		this.diretores = diretores;
	}

	/* MÉTODOS DA CLASSE PRESIDENTE */

	public void emitirRelatorioBanco() {

		/* Ter acesso ao capital do banco, emitir performance das agencias,
		 * supervisionar os relatorios dos diretores e gerentes, etc. */
	}

}
