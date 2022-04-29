package br.com.residencia.poo.pessoas;

public class Gerente extends Funcionario {

	private Integer numeroAgencia;

	public Gerente() {
		super();
	}

	public Gerente(String tipoUsuario, String nome, String cpf, String senha, Integer agencia, Integer numeroDaConta,
			Double salario, Integer numeroAgencia) {
		super(tipoUsuario, nome, cpf, senha, agencia, numeroDaConta, salario);

		this.numeroAgencia = numeroAgencia;
	}

	public Integer getNumeroAgencia() {
		return this.numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	@Override
	public String toString() {
		return "Gerente [numeroAgencia=" + this.numeroAgencia + ", salario=" + this.salario + ", nome=" + this.nome
				+ ", tipoUsuario=" + this.tipoUsuario + ", cpf=" + this.cpf + ", senha=" + this.senha + ", agencia="
				+ this.agencia + ", numeroDaConta=" + this.numeroDaConta + "]\n";
	}

}
