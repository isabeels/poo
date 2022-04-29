package br.com.residencia.poo.principal;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.com.residencia.poo.agencias.Agencia;
import br.com.residencia.poo.contas.Conta;
import br.com.residencia.poo.contas.ContaCorrente;
import br.com.residencia.poo.contas.ContaPoupanca;
import br.com.residencia.poo.exceptions.CpfInvalidoException;
import br.com.residencia.poo.exceptions.OperacaoNaoAutorizadaException;
import br.com.residencia.poo.exceptions.SaldoInsuficienteException;
import br.com.residencia.poo.exceptions.ValorInvalidoException;
import br.com.residencia.poo.menu.LoginFrame;
import br.com.residencia.poo.menu.Menu;
import br.com.residencia.poo.pessoas.Cliente;
import br.com.residencia.poo.pessoas.Diretor;
import br.com.residencia.poo.pessoas.Funcionario;
import br.com.residencia.poo.pessoas.Gerente;
import br.com.residencia.poo.pessoas.Pessoa;
import br.com.residencia.poo.pessoas.Presidente;

public class Principal {
	
	public static void login() {
		JFrame a = new JFrame("Contas Poupança Cadastro");
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		JPanel j= new JPanel(new GridBagLayout());
		
		
		JLabel usuarioLabel = new JLabel("Usuário: ");
		
		a.add(usuarioLabel);
		
		JLabel senhaLabel = new JLabel("Senha: ");
		
		
		a.add(senhaLabel);
		
		
		a.setSize(400,600);
		a.setVisible(true);
		
	   
	}
	public static void viewContaPoupanca(List<ContaPoupanca> conta) {
		JFrame a = new JFrame("Contas Poupança Cadastro");
		DefaultListModel<String> l = new DefaultListModel<>();

		String column[] = { "CPF", "Numero da Conta", "Id conta poupança" };

		String[][] test = new String[conta.size()][3];
		for (int i = 0; i < conta.size(); i++) {
			test[i][0] = conta.get(i).getCpfTitular().getCpf();
			test[i][1] = conta.get(i).getNumeroConta();
			test[i][2] = conta.get(i).getIdContaPoupanca().toString();

		}

		JTable jt = new JTable(test, column);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);

		a.add(sp);
		a.setSize(400,600);
		a.setVisible(true);
	}

	public static void viewContaCorrente(List<ContaCorrente> conta) {

		JFrame a = new JFrame("Contas Corrente Cadastradas");
		DefaultListModel<String> l = new DefaultListModel<>();

		String column[] = { "CPF", "Numero da Conta", "Id conta poupança" };

		String[][] test = new String[conta.size()][3];
		for (int i = 0; i < conta.size(); i++) {
			test[i][0] = conta.get(i).getCpfTitular().getCpf();
			test[i][1] = conta.get(i).getNumeroConta();
			test[i][2] = conta.get(i).getIdContaCorrente().toString();

		}

		JTable jt = new JTable(test, column);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);

		a.add(sp);
		a.setSize(600, 800);
		a.setVisible(true);

	}

	public static void main(String[] args) throws ValorInvalidoException, SaldoInsuficienteException,
			CpfInvalidoException, OperacaoNaoAutorizadaException, IOException {
		
		Menu frame = new Menu();
		frame.Show();
		
		
		
		List<Conta> contasAgenciaUm;
		contasAgenciaUm = new ArrayList<Conta>();
		List<Conta> contasAgenciaDois;
		contasAgenciaDois = new ArrayList<Conta>();

		List<ContaCorrente> contasC;
		contasC = new ArrayList<ContaCorrente>();
		List<ContaPoupanca> contasP;
		contasP = new ArrayList<ContaPoupanca>();

		/* Lista diretor */
		List<Diretor> diretores;
		diretores = new ArrayList<Diretor>();

		/* Lista gerencia */
		List<Gerente> gerentes;
		gerentes = new ArrayList<Gerente>();

		/* Lista Clientes */
		List<Cliente> clientes;
		clientes = new ArrayList<Cliente>();

//								   |
		/* Instanciação de contas \|/ (pode apagar, se precisar) */

		Pessoa p1 = new Pessoa("Isabel", "617.781.430-16", "Gerente");
		Pessoa p2 = new Pessoa("Vinicius", "918.487.130-02", "Gerente");
		Pessoa p3 = new Pessoa("Gabriel", "338.720.490-62", "Gerente");
		Pessoa p4 = new Pessoa("Rosana", "169.269.810-94", "Gerente");
		Pessoa p5 = new Pessoa("Charlles", "722.003.340-01", "Gerente");
		Pessoa p6 = new Pessoa("Flavio", "693.842.680-54", "Gerente");

		ContaCorrente cc1 = new ContaCorrente(p1, "2314", "0784086-1");
		System.out.println(cc1.toString());
		cc1.depositar(300);
		System.out.println(cc1.toString());

		ContaCorrente cc2 = new ContaCorrente(p2, "4132", "1680487-0");
		System.out.println(cc2.toString());
		cc2.depositar(2545);
		System.out.println(cc2.toString());

		contasC.add(cc1);
		contasC.add(cc2);
		viewContaCorrente(contasC);

		ContaPoupanca cc3 = new ContaPoupanca(p3, "3605", "1010177-8");
		System.out.println(cc3.toString());
		cc3.depositar(2623);
		System.out.println(cc3.toString());

		ContaPoupanca cc4 = new ContaPoupanca(p4, "5873", "7526394-4");
		System.out.println(cc4.toString());
		cc4.depositar(6253);
		System.out.println(cc4.toString());

		contasP.add(cc3);
		contasP.add(cc4);
		viewContaPoupanca(contasP);

		/* Adicionar uma lista para guardar todas as agências instanciadas */
		/* Sintaxe -> List<TIPO> nomedoobjeto = new LISTA<TIPO>; */
		List<Agencia> agencias;
		agencias = new ArrayList<Agencia>();

		/* Instanciação de agência */
		Agencia ag = new Agencia(1, "Avenida das Palmeiras", 1000, 1005, 1001, contasAgenciaUm);
		agencias.add(ag);

		Agencia age = new Agencia(1, "Avenida do Aconchego", 1000, 1000, 1002, contasAgenciaUm);
		agencias.add(age);

		// INSTANCIAÇÃO DOS FUNCIONÁRIOS

		/* Gerente Gabriel */
//		Gerente Gabriel = new Gerente("Gabriel", "todos","Casado", "1112223334", "22-999093552", "Rua da paixão",
//				"gabrieltsf10@gmail.com", data , "gerente", 2, "gabriel1", "gabriellocao",
//				127.000, "Gerente geral", 1004, 1005, contasAgenciaUm);
//		gerentes.add(Gabriel);
//		
//		
//		/* Gerente Rosana */
//		Gerente Rosana = new Gerente("Rosana", "Sem gênero definido","Casada", "1112220004", "22-23252718", "Estrada novo circuito",
//				"dantasdoqa@gmail.com", data , "gerente", 2, "gabriel1", "gabriellocao",
//				127.000, "Gerente geral", 1005, 1000, contasAgenciaUm);
//		gerentes.add(Rosana);
//		
//		
//		/* Diretor Vinícius */
//		Diretor Vinicius = new Diretor("Vinicin", "Não supomos genero", "Casado", "123999666-6", "22-1313131313", "Rua do cruzeiro",
//				"vinivspdasgata@gmail.com", data , "diretor", 1001, "palhaço1", "fazumapalhaçadinha",
//				17.99, "Diretor geral das palhaçadinha", 1000, agencias, gerentes);
//		diretores.add(Vinicius);
//		
//		/* Presidenta Isabel */
//		Presidente Isabel = new Presidente("Isabel", "Ela/Dela", "Casada", "Informação Oculta", "21-1313131313", "Rua da Liderança",
//			"devsixlider@devsix.br", data, "Presidente", 13, "adminlider", "naoousehackearapresidenta",
//			199_488_130.12, "Presidente", 1, diretores);

		/* Instanciação de clientes */
//		Cliente Harumi = new Cliente("Harumi Hiroshi Jun", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Kenji Akira Abenyu",
//				"youtube@gmail.com", data, "Cliente", 2, 1005);
//		clientes.add(Harumi);
//		Cliente Lesheshenko = new Cliente("Lesheshenko Plushchenko", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Romaniuk Avenue",
//				"ukraineliberationarmy@gmail.com", data, "Cliente", 2, 1005);
//		clientes.add(Lesheshenko);
//		Cliente HarumotoYakasaki = new Cliente("HarumotoYakasaki", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Tsumago-juku",
//				"tsumagojuku@gmail.com.jp", data, "Cliente", 3, 1005);
//		clientes.add(HarumotoYakasaki);
//		Cliente Wladimir = new Cliente("Wladimir BERELOWITCH", "Elu/Delu", "Solteire", "9997775544", "21-87674552", "Nikolai Dimitri Street",
//				"russianvodkaforfree@gmail.com", data, "Cliente/Vendedor de Vodka", 4, 1005);
//		clientes.add(Wladimir);
//		Cliente Kwasi = new Cliente("Kwasi Oppong", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Fumesua-Kokobra",
//				"shumetsu@gmail.com", data, "Cliente", 5, 1005);
//		clientes.add(Kwasi);
//		Cliente Yousaf = new Cliente("Yousaf Manzil", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Malik-Salam",
//				"shumetsu@gmail.com", data, "Cliente", 5, 1005);
//		clientes.add(Yousaf);
//		Cliente Chaikinoy = new Cliente("Chaikinoy", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Rua árabe",
//				"shumetsu@gmail.com", data, "Cliente", 5, 1005);
//		clientes.add(Chaikinoy);
//		

		System.out.print("\n");
		/* Output dos clientes */
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println("Cliente " + (i + 1) + ": ");
			System.out.print(clientes.get(i).getNome() + "\n");
		}
		System.out.print("\n");
		/* Output dos Gerentes */
		for (int i = 0; i < gerentes.size(); i++) {
			System.out.println("Gerente " + (i + 1) + ": ");
			System.out.println(gerentes.get(i).getNome() + "\n");
		}
		System.out.print("\n");

		/* Output dos Diretores */
		for (int i = 0; i < diretores.size(); i++) {
			System.out.println("Diretor " + (i + 1) + ": ");
			System.out.print(diretores.get(i).getNome() + "\n");
		}
		System.out.print("\n");

		/* Output das Agencias */
		// for(int i=0;i<agencias.size();i++) {
		// System.out.println("Agencia "+(i+1)+": ");
		// System.out.println(agencias.get(i).getIdAgencia()+"\n");
		// }

		System.out.println("\n\n\n\n");
		// Rosana.emitirRelatorioContas();
		// Gabriel.emitirRelatorioContas();
//		ag.emitirRelatorioContas();

		System.out.println("\n\n\n\n");
		// Vinicius.emitirRelatorioAgencias();

	}

}
