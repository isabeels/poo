package br.com.residencia.poo.principal;

import br.com.residencia.poo.contas.Conta;

public class Principal {

	public static void main(String[] args) {
		
		Conta conta1 = new Conta(1, "3761", "Conta Corrente", "89121-5", 0.15, null , true, "123");
		
		System.out.println(conta1.toString());
		
		
		
	}

}
