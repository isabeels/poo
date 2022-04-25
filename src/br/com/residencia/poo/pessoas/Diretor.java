package br.com.residencia.poo.pessoas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.residencia.poo.agencias.Agencia;

public class Diretor extends Funcionario {

	/* ATRIBUTOS */
	protected Integer idDiretor;
	protected List<Agencia> agenciaTrabalho = new ArrayList<>();

	/* CONSTRUTOR PARA INSTANCIAR NOVOS DIRETORES INVOCANDO SUPERCLASSE FUNCIONARIO*/
	public Diretor(String nome, String genero, String estadoCivil, String cpf, String telefone, String endereco,
			String email, Date dataNascimento, String tipoPessoa, Integer idFuncionario, String login, String senha,
			Double salario, String cargo, Integer idDiretor, List<Agencia> agenciaTrabalho) {
		super(nome, genero, estadoCivil, cpf, telefone, endereco, email, dataNascimento, tipoPessoa, idFuncionario,
				login, senha, salario, cargo);
		this.idDiretor = idDiretor;
		this.agenciaTrabalho = agenciaTrabalho;
	}

	/* GETTERS E SETTERS */
	public Integer getIdDiretor() {
		return idDiretor;
	}

	public void setIdDiretor(Integer idDiretor) {
		this.idDiretor = idDiretor;
	}

	public List<Agencia> getAgenciaTrabalho() {
		return agenciaTrabalho;
	}

	public void setAgenciaTrabalho(List<Agencia> agenciaTrabalho) {
		this.agenciaTrabalho = agenciaTrabalho;
	}

	/* MÉTODOS DA CLASSE DIRETOR */

	public void emitirRelatorioAgencias() {
		for(int i=0;i<agenciaTrabalho.size();i++) {
			System.out.println("ID da Agência "+(i+1)+": "+agenciaTrabalho.get(i).getIdAgencia()+"\n");
			System.out.println("Agência Nº : "+agenciaTrabalho.get(i).getNumeroAgencia()+"\n");
			System.out.println("Id do Diretor : "+agenciaTrabalho.get(i).getIdDiretor()+"\n");
			System.out.println("Localização : "+agenciaTrabalho.get(i).getEndereco()+"\n");
			System.out.println("Id do Gerente Geral : "+agenciaTrabalho.get(i).getIdGerente()+"\n");
			System.out.println("Faturamento : "+agenciaTrabalho.get(i).getFaturamento()+"\n");
		}
	}

}
