package br.com.residencia.poo.principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.residencia.poo.agencias.Agencia;
import br.com.residencia.poo.contas.Conta;
import br.com.residencia.poo.pessoas.Cliente;
import br.com.residencia.poo.pessoas.Diretor;
import br.com.residencia.poo.pessoas.Funcionario;
import br.com.residencia.poo.pessoas.Gerente;

public class Principal {

	public static void main(String[] args) {
		/* Lista contas */
		List<Conta> contas;
		contas = new ArrayList<Conta>();
		/*  */
		
		
		/* Instanciação de contas */
		Conta conta1 = new Conta(1, "3761", "Conta Corrente", "89121-5", 0.15, true, "123");
		System.out.println(conta1.toString());
		contas.add(conta1);
		
		Conta conta2 = new Conta(2, "1673", "Conta Corrente", "51219-8", 1562.00, true, "321");
		System.out.println(conta2.toString());
		contas.add(conta2);
		
		Date data = new Date();
		System.out.println(data);
		
		

		/* Adicionar uma lista para guardar todas as agências instanciadas */
		/* Sintaxe -> List<TIPO> nomedoobjeto = new LISTA<TIPO>; */
		List<Agencia> agencias;
		agencias = new ArrayList<Agencia>();
		
		/* Instanciação de agência */
		Agencia ag = new Agencia(1, "Avenida das Palmeiras", 1000, 1005, 1001);
		agencias.add(ag);
		/*  */
		
		//System.out.println(agencias.get(0).getIdAgencia());
		
		
		
		//INSTANCIAÇÃO DOS FUNCIONÁRIOS
		
		/* Gerente Gabriel */
		Gerente Gabriel = new Gerente("Gabriel", "todos","Casado", "1112223334", "22-999093552", "Rua da paixão",
				"gabrieltsf10@gmail.com", data , "gerente", 2, "gabriel1", "gabriellocao",
				127.000, "Gerente geral", 1005, 1000);
		/*  */
		
		/* Gerente Rosana */
		Gerente Rosana = new Gerente("Rosana", "Sem gênero definido","Casada", "1112220004", "22-23252718", "Estrada novo circuito",
				"dantasdoqa@gmail.com", data , "gerente", 2, "gabriel1", "gabriellocao",
				127.000, "Gerente geral", 1005, 1000);
		/*  */
		
		/* Diretor Vinícius */
		Diretor diretor = new Diretor("Vinicin", "Não supomos genero", "Casado", "123999666-6", "22-1313131313", "Rua do cruzeiro",
				"vinivspdasgata@gmail.com", data , "diretor", 1001, "palhaço1", "fazumapalhaçadinha",
				17.99, "Diretor geral das palhaçadinha", 1000, agencias);
		
		
		
		
		/* Adicionar uma lista para guardar todos os clientes instanciados */
		List<Cliente> clientes;
		clientes = new ArrayList<Cliente>();
		
		
		/* Instanciação de clientes */
		Cliente aleatorio = new Cliente("Aleatório", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Rua do colírio",
				"youtube@gmail.com", data, "Cliente", 2, 1005);
		clientes.add(aleatorio);
		Cliente HarumotoYakasaki = new Cliente("HarumotoYakasaki", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Tsumago-juku",
				"tsumagojuku@gmail.com.jp", data, "Cliente", 3, 1005);
		clientes.add(HarumotoYakasaki);
		Cliente Wladimir = new Cliente("Wladimir BERELOWITCH", "Elu/Delu", "Solteire", "9997775544", "21-87674552", "Nikolai Dimitri Street",
				"youtube@gmail.com", data, "Cliente", 4, 1005);
		clientes.add(Wladimir);
		Cliente Kwasi = new Cliente("Kwasi Oppong", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Fumesua-Kokobra",
				"shumetsu@gmail.com", data, "Cliente", 5, 1005);
		clientes.add(Kwasi);
		Cliente Yousaf = new Cliente("Yousaf Manzil", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Malik-Salam",
				"shumetsu@gmail.com", data, "Cliente", 5, 1005);
		clientes.add(Yousaf);
		Cliente Chaikinoy = new Cliente("Chaikinoy", "Elu/Delu", "Casade", "9997775544", "21-87674552", "Rua árabe",
				"shumetsu@gmail.com", data, "Cliente", 5, 1005);
		clientes.add(Chaikinoy);
		
		
		
		/* Output dos clientes */
		for(int i=0;i<clientes.size();i++) {
			System.out.println("Cliente "+(i+1));
			System.out.println(clientes.get(i).getNome());
		}
		

	}

}
