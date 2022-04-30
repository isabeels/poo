package br.com.residencia.poo.menu;

import java.io.IOException;
import java.util.InputMismatchException;

import br.com.residencia.poo.io.LeituraEscrita;
import br.com.residencia.poo.contas.Conta;
import br.com.residencia.poo.exceptions.ContaException;
import br.com.residencia.poo.pessoas.Usuario;
import br.com.residencia.poo.principal.Principal;

public class MenuPrincipal {
	
	double inputValor;
	static String inputCpf;
	int operacao;

	public static void menuPrincipal(Usuario usuario, Conta conta)
			throws InputMismatchException, NullPointerException, ContaException, IOException {
		Principal principal = new Principal();
		
		try {

			principal.pulaLinha();
			System.out.println("[1]\tSAQUE");
			System.out.println("[2]\tDEPÓSITO");
			System.out.println("[3]\tTRANSFERÊNCIA");
			System.out.println("[4]\tSALDO");
			System.out.println("[5]\tRELATÓRIO");
			System.out.println("[6]\tSIMULAÇÃO DE RENDIMENTO DA POUPANÇA");
			System.out.println("[7]\tSAIR");
			principal.imprimeLinhaHorizontal();

			System.out.print("Digite a opção desejada: ");
			int opcaoOperacao = Principal.sc.nextInt();
			Double inputValor;

			
			switch (opcaoOperacao) {
			case 1:
				principal.imprimeLinhaHorizontal();
				System.out.print("Digite o valor que deseja sacar: ");
				inputValor = Double.parseDouble(Principal.sc.next());

				conta.saca(inputValor);

				LeituraEscrita.comprovanteSaque(conta, inputValor);

				principal.pulaLinha();

				break;
			case 2:
				principal.imprimeLinhaHorizontal();
				System.out.print("Digite o valor que deseja depositar: ");
				inputValor = Double.parseDouble(Principal.sc.next());

				conta.deposita(inputValor);

				LeituraEscrita.comprovanteDeposito(conta, inputValor);

				principal.pulaLinha();

				break;

			case 3:

				principal.imprimeLinhaHorizontal();
				System.out.print("Digite o valor que deseja transferir: ");
				inputValor = Double.parseDouble(Principal.sc.next());
				System.out.print("Digite o cpf da conta que deseja transferir: ");
				String contaDestino = Principal.sc.next();
				if (!Conta.mapaContas.get(contaDestino).equals(null)) {
					Conta cD = Conta.mapaContas.get(contaDestino);
					conta.transfere(cD, inputValor);
					LeituraEscrita.comprovanteTransferencia(conta, cD, inputValor);
				} else {
					System.out.println("Conta não encontrada");
				}

				break;

			case 4:
				principal.imprimeLinhaHorizontal();
				System.out.printf("O valor do seu saldo é R$ %.2f\n", conta.getSaldo());

			case 5:
				switch (usuario.getTipoUsuario()) {
				case "PRESIDENTE":
					LeituraEscrita.relatorioTotalCapital(conta, Conta.mapaContas);
					System.out.println("Seu arquivo de relatório foi gerado com as informações do capital do Banco");
					break;
				case "DIRETOR":
					LeituraEscrita.relatorioContasPorAgencia(conta);
					System.out
							.println("Seu arquivo de relatório foi gerado com as informações das Contas das Agências");
					break;
				case "GERENTE":
					LeituraEscrita.relatorioContasPorAgencia(conta);
					System.out.println("Seu arquivo de relatório foi gerado com as informações das Contas das Agências");
					break;
				}
				
			case 6:
				principal.imprimeLinhaHorizontal();
				System.out.print("Digite o valor que deseja simular: ");
				inputValor = Double.parseDouble(Principal.sc.next());
				
				System.out.print("Digite a quantidade de dias que deseja simular: ");
				Integer inputDias = Integer.parseInt(Principal.sc.next());

				LeituraEscrita.relatorioRendimentoPoupanca(conta, inputValor, inputDias);
				System.out.println("Seu arquivo de simulação de rendimentos da poupança foi gerado com sucesso!");
				
				break;

			case 7:
				principal.limpaTela();
				principal.menuInterativo();
				break;

			default:

				principal.pulaLinha();
				System.out.println("Opção inválida!");

			}

			menuPrincipal(usuario, conta);

		} catch (

		ContaException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			menuPrincipal(usuario, conta);
		}
	}
}