package br.com.residencia.poo.pessoas;

public class Diretor extends Funcionario {

//	List<Agencia> listaAgencia = new ArrayList<>();

	public Diretor() {
		super();
	}

	public Diretor(String tipoUsuario, String nome, String cpf, String senha, Integer agencia, Integer numeroDaConta,
			Double salario) {
		super(tipoUsuario, nome, cpf, senha, agencia, numeroDaConta, salario);
	}

	@Override
	public String toString() {
		return "Diretor [salario=" + this.salario + ", nome=" + this.nome + ", tipoUsuario=" + this.tipoUsuario
				+ ", cpf=" + this.cpf + ", senha=" + this.senha + ", agencia=" + this.agencia + ", numeroConta="
				+ this.numeroDaConta + "]\n";
	}

}
