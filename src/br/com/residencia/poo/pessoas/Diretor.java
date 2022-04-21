package br.com.residencia.poo.pessoas;

import java.util.ArrayList;
import java.util.List;
import br.com.residencia.poo.agencias.Agencia;

public class Diretor extends Funcionario{
	Integer idDiretor;
	List<Agencia>agenciaTrabalho = new ArrayList<>();
	
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

}
