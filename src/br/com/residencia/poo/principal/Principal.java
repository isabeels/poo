package br.com.residencia.poo.principal;

import br.com.residencia.poo.contas.Conta;
import br.com.residencia.poo.pessoas.Gerente;

public class Principal {

	public static void main(String[] args) {

		Conta conta1 = new Conta(1, "3761", "Conta Corrente", "89121-5", 0.15, true, "123");
		System.out.println(conta1.toString());
		
		Conta conta2 = new Conta(2, "1673", "Conta Corrente", "51219-8", 1562.00, true, "321");
		System.out.println(conta2.toString());


	}

}
