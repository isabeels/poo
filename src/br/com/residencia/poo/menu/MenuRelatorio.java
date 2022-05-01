package br.com.residencia.poo.menu;

import java.io.IOException;
import java.util.InputMismatchException;

import br.com.residencia.poo.io.LeituraEscrita;
import br.com.residencia.poo.contas.Conta;
import br.com.residencia.poo.contas.ContaCorrente;
import br.com.residencia.poo.contas.ContaPoupanca;
import br.com.residencia.poo.enums.TipoConta;
import br.com.residencia.poo.enums.TipoPessoa;
import br.com.residencia.poo.exceptions.ContaException;
import br.com.residencia.poo.pessoas.Usuario;
import br.com.residencia.poo.principal.Principal;
import br.com.residencia.poo.interfaces.Taxas;

public class MenuRelatorio {
	
	Principal principal = new Principal();
	int teste;
	int operacao;
	MenuPrincipal menuPrincipal = new MenuPrincipal();

	public static void menuRelatorio(Integer idUsuario, Usuario usuario, Conta conta)
			throws IOException, InputMismatchException, NullPointerException, ContaException {

		Principal principal = new Principal();

		principal.pulaLinha();

		if (conta.getTipoConta().equalsIgnoreCase(TipoConta.CORRENTE.getTipoConta())) {
			System.out.println("[1]\tTributação conta corrente");
		} else {
			System.out.println("[1]\tSimulacao de rendimento");
		}
		if (idUsuario == 2) {
			System.out.println("[2]\tRelatório de contas gerenciadas");
		} else if (idUsuario == 3) {
			System.out.println("[2]\tRelatório de todas as contas e agências");
		} else if (idUsuario == 4){
			System.out.println("[2]\tRelatório com o total de capital do Banco");
		}
		
		System.out.println("[3]\tVoltar");
		imprimeLinhaHorizontal();

		System.out.print("Digite a opção desejada: ");
		int operacao = Principal.sc.nextInt();

		principal.pulaLinha();

		switch (operacao) {

		case 1:

			if (conta.getTipoConta().equalsIgnoreCase(TipoConta.CORRENTE.getTipoConta())) {

				System.out.printf("O total gasto com operações foi de R$%.2f%n",
						((ContaCorrente) conta).getTotalTributado());
				System.out.printf("O valor cobrado para cada saque é de R$%.2f%n", Taxas.SAQUE);
				System.out.println("Total de saques realizados: " + ((ContaCorrente) conta).getTotalSaques());
				System.out.printf("O valor cobrado para cada deposito é de R$%.2f%n", Taxas.DEPOSITO);
				System.out.println("Total de depósitos realizados: " + ((ContaCorrente) conta).getTotalDepositos());
				System.out.printf("O valor cobrado para cada tranferência é de R$%.2f%n", Taxas.TRANSFERENCIA);
				System.out.println(
						"Total de transferências realizadas: " + ((ContaCorrente) conta).getTotalTransferencias());
				Integer totalDep = ((ContaCorrente) conta).getTotalSaques();
				Integer totalSaq =  ((ContaCorrente) conta).getTotalDepositos();
				LeituraEscrita.relatorioTributacaoContaCorrente(conta, totalDep, totalSaq);
				System.out.println("\nSeu arquivo foi gerado com sucesso!");
			} else {

				int inputDias;
				double inputValor;

				System.out.println("Digite o valor que deseja usar para a simulação: ");
				inputValor = Double.parseDouble(Principal.sc.next());

				System.out.println("Digite o número de dias para a simulação: ");
				inputDias = Principal.sc.nextInt();

				((ContaPoupanca) conta).previsaoDeRendimento(inputValor, inputDias);

				LeituraEscrita.relatorioRendimentoPoupanca(conta, inputValor, inputDias);
				
				System.out.println("\nSeu arquivo foi gerado com sucesso!");
			}

			selecaoRelatorio(conta, usuario);

			break;

		case 2:
			if (idUsuario == 2) {
				LeituraEscrita.relatorioContasGerenciadas(conta);
				System.out.println("\nSeu arquivo foi gerado com sucesso!");
			}
		 else if (idUsuario == 3){
			 for (String cpf : Conta.mapaContas.keySet()) {
			System.out.println(Conta.mapaContas.get(cpf));
			 }
			 
			 LeituraEscrita.relatorioContasPorAgencia(conta);
			 System.out.println("\nSeu arquivo foi gerado com sucesso!");
		} else {
				LeituraEscrita.relatorioTotalCapital(conta, Conta.mapaContas);
				System.out.println("\nSeu arquivo foi gerado com sucesso!");
			}
			
			selecaoRelatorio(conta, usuario);

			break;
			
		

		case 3:

			principal.limpaTela();
			MenuPrincipal.menuPrincipal(usuario, conta);
			break;

		default:

			principal.pulaLinha();
			System.out.println("Opção inválida!");
			selecaoRelatorio(conta, usuario);

		}

	}

	public static void selecaoRelatorio(Conta conta, Usuario usuario)
			throws InputMismatchException, NullPointerException, ContaException, IOException {

		if (usuario.getTipoUsuario().equalsIgnoreCase(TipoPessoa.CLIENTE.getTipoUsuario())) {
			MenuRelatorio.menuRelatorio(TipoPessoa.CLIENTE.getIdTipoUsuario(), usuario, conta);
		} else if (usuario.getTipoUsuario().equalsIgnoreCase(TipoPessoa.GERENTE.getTipoUsuario())) {
			MenuRelatorio.menuRelatorio(TipoPessoa.GERENTE.getIdTipoUsuario(), usuario, conta);
		} else if (usuario.getTipoUsuario().equalsIgnoreCase(TipoPessoa.DIRETOR.getTipoUsuario())) {
			MenuRelatorio.menuRelatorio(TipoPessoa.DIRETOR.getIdTipoUsuario(), usuario, conta);
		} else if (usuario.getTipoUsuario().equalsIgnoreCase(TipoPessoa.PRESIDENTE.getTipoUsuario())) {
			MenuRelatorio.menuRelatorio(TipoPessoa.PRESIDENTE.getIdTipoUsuario(), usuario, conta);
		}
	}

	public static void imprimeLinhaHorizontal() {
		System.out.println("--------------------------------------------------");
	}

}