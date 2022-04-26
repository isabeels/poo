package br.com.residencia.poo.pessoas;

import java.util.Date;
import java.util.List;

import br.com.residencia.poo.contas.Conta;

import java.util.ArrayList;

public class Gerente extends Funcionario {

	/* ATRIBUTOS */
	protected Integer idGerente;
	protected Integer numeroAgencia;
	protected List<Conta> contas = new ArrayList<>();

	/*CONSTRUTOR PARA INSTANCIAR NOVOS GERENTES INVOCANDO SUPERCLASSE FUNCIONARIO*/
	public Gerente(String nome, String genero, String estadoCivil, String cpf, String telefone, String endereco,
			String email, Date dataNascimento, String tipoPessoa, Integer idFuncionario, String login, String senha,
			Double salario, String cargo, Integer idGerente, Integer numeroAgencia) {

		super(nome, genero, estadoCivil, cpf, telefone, endereco, email, dataNascimento, tipoPessoa, idFuncionario,
				login, senha, salario, cargo);

		this.idGerente = idGerente;
		this.numeroAgencia = numeroAgencia;
		
	}
	public Gerente(String nome, String genero, String estadoCivil, String cpf, String telefone, String endereco,
			String email, Date dataNascimento, String tipoPessoa, Integer idFuncionario, String login, String senha,
			Double salario, String cargo, Integer idGerente, Integer numeroAgencia, List<Conta> contas) {

		super(nome, genero, estadoCivil, cpf, telefone, endereco, email, dataNascimento, tipoPessoa, idFuncionario,
				login, senha, salario, cargo);

		this.idGerente = idGerente;
		this.numeroAgencia = numeroAgencia;
		this.contas = contas;
		
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
		for(int i=0;i<contas.size();i++) {
			System.out.println("Conta "+(i+1)+": "+contas.get(i).getNumeroConta());
			System.out.println(contas.get(i).getNumeroAgencia()+"\n");
			System.out.println(contas.get(i).getTipoConta()+"\n");
			System.out.println(contas.get(i).getIdConta()+"\n");
			
		}
	}
}
