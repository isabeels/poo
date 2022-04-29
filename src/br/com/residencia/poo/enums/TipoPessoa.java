package br.com.residencia.poo.enums;

public enum TipoPessoa {
	CLIENTE("cliente", 1), GERENTE("gerente", 2), DIRETOR("diretor", 3), PRESIDENTE("presidente", 4);

	private final Integer idTipoUsuario;
	private final String tipoUsuario;

	TipoPessoa(String tipoUsuario, Integer idTipoUsuario) {
		this.tipoUsuario = tipoUsuario;
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public Integer getIdTipoUsuario() {
		return this.idTipoUsuario;
	}

}
