package br.com.residencia.poo.pessoas;

import java.util.ArrayList;
import java.util.List;

public class Presidente extends Funcionario {
	Integer idPresidente;
	List<Diretor> diretores = new ArrayList<>();
	
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

	
}
