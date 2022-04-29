package br.com.residencia.poo.pessoas;

import java.util.Date;

public class Cliente extends Usuario {

	public Cliente() {
		super();
	}

	public Cliente(String tipoUsuario, String nome, String cpf, String senha, Integer agencia, Integer numeroDaConta) {
		super(tipoUsuario, nome, cpf, senha, agencia, numeroDaConta);

	}

	@Override
	public String toString() {
		return "Cliente [Nome: " + this.nome + ", tipoUsuario=" + this.tipoUsuario
				+ ", cpf=" + this.cpf + ", senha=" + this.senha + ", agencia=" + this.agencia + ", numeroDaConta="
				+ this.numeroDaConta + "]\n";
	}

}
