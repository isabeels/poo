package br.com.residencia.poo.pessoas;

public abstract class Funcionario extends Usuario {

	protected Double salario;

	public Funcionario() {
		super();
	}

	public Funcionario(String tipoUsuario, String nome, String cpf, String senha, Integer agencia,
			Integer numeroDaConta, Double salario) {
		super(tipoUsuario, nome, cpf, senha, agencia, numeroDaConta);

		this.salario = salario;
	}

	public Double getSalario() {
		return this.salario;
	}

	@Override
	public String toString() {
		return "Funcionario [salario=" + this.salario + ", nome=" + this.nome + ", tipoUsuario=" + this.tipoUsuario
				+ ", cpf=" + this.cpf + ", senha=" + this.senha + ", agencia=" + this.agencia + ", numeroConta="
				+ this.numeroDaConta + "]\n";
	}

}
