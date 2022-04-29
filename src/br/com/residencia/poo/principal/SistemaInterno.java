package br.com.residencia.poo.principal;

import java.io.IOException;
import java.util.InputMismatchException;

import br.com.residencia.poo.io.LeituraEscrita;
import br.com.residencia.poo.exceptions.ContaException;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, InputMismatchException, NullPointerException, ContaException {

				LeituraEscrita.leitor("entradaDeDados.txt");

				Principal principal = new Principal();
				principal.menuInterativo();

			}

		}

