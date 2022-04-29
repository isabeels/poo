package br.com.residencia.poo.agencias;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import br.com.residencia.poo.contas.Conta;

public class Agencia {

	/* ATRIBUTOS */
	private Integer idAgencia;
	private String endereco;
	private Integer numeroAgencia;
	private Integer idGerente;
	private Integer idDiretor;
	private Integer faturamento;
	private List<Conta> contas;

	/* CONSTRUTOR PARA INSTANCIAR NOVAS AGENCIAS */
	public Agencia(Integer idAgencia, String endereco, Integer numeroAgencia, Integer idGerente, Integer idDiretor, List<Conta> contas) {
		super();
		this.idAgencia = idAgencia;
		this.endereco = endereco;
		this.numeroAgencia = numeroAgencia;
		this.idGerente = idGerente;
		this.idDiretor = idDiretor;
		this.contas = contas;
	}

	/* GETTERS E SETTERS */
	public Integer getIdAgencia() {
		return idAgencia;
	}

	public String getEndereco() {
		return endereco;
	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public Integer getIdGerente() {
		return idGerente;
	}

	public Integer getIdDiretor() {
		return idDiretor;
	}
	
	public Integer getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(Integer fat) {
		this.faturamento = fat;
	}
	public void emitirRelatorioContas() {
		int i;
		for(i=0;i<contas.size();i++) {
				System.out.print("Conta "+(i+1)+": ");
				System.out.println(contas.get(i).getNumeroConta()+"        Saldo "+contas.get(i).getSaldo());	
		}
		System.out.println("__________________________________________");
		System.out.println("Total de capital na Agencia: "+faturamentoTotal());
		System.out.println("Total de contas na Agencia: "+contas.get(i-1).getNumeroConta());
		System.out.println("__________________________________________");
	
	}
	
	public double faturamentoTotal() {
		double total=0.0;
		for(int i=0;i<contas.size();i++) {
			total+=contas.get(i).getSaldo();
		}
		return total;	
	}
	

}
