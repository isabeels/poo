package br.com.residencia.poo.pessoas;

public class Presidente extends Funcionario {

	public Presidente() {
		super();
	}

	public Presidente(String tipoUsuario, String nome, String cpf, String senha, Integer agencia, Integer numeroDaConta,
			Double salario) {
		super(tipoUsuario, nome, cpf, senha, agencia, numeroDaConta, salario);
	}

	@Override
	public String toString() {
		return "Presidente [salario=" + this.salario + ", nome=" + this.nome + ", tipoUsuario=" + this.tipoUsuario
				+ ", cpf=" + this.cpf + ", senha=" + this.senha + ", agencia=" + this.agencia + ", numeroConta="
				+ this.numeroDaConta + "]\n";
	}

}