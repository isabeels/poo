package br.com.residencia.poo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import br.com.residencia.poo.contas.Conta;
import br.com.residencia.poo.contas.ContaCorrente;
import br.com.residencia.poo.contas.ContaPoupanca;
import br.com.residencia.poo.enums.TipoConta;
import br.com.residencia.poo.enums.TipoPessoa;
import br.com.residencia.poo.exceptions.ContaException;
import br.com.residencia.poo.interfaces.Taxas;
import br.com.residencia.poo.pessoas.Cliente;
import br.com.residencia.poo.pessoas.Gerente;
import br.com.residencia.poo.pessoas.Usuario;

public class LeituraEscrita {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path));

		String linha = "";

		while (true) {
			linha = buffRead.readLine();

			if (linha != null) {
				String[] dados = linha.split(";");

				if (dados[0].equalsIgnoreCase(TipoConta.CORRENTE.getTipoConta())) {

					ContaCorrente cc = new ContaCorrente(dados[0], Integer.parseInt(dados[1]),
							Integer.parseInt(dados[2]), Double.parseDouble(dados[3]), dados[4]);

					Conta.mapaContas.put(dados[4], cc);

				} else if (dados[0].equalsIgnoreCase(TipoPessoa.CLIENTE.getTipoUsuario())) {

					Cliente cli = new Cliente(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]),
							Integer.parseInt(dados[5]));

					Usuario.mapaUsuarios.put(dados[2], cli);
					Usuario.OrdenaUsuarios.put(dados[1], cli);

				} else if (dados[0].equalsIgnoreCase(TipoPessoa.GERENTE.getTipoUsuario())) {

					Gerente gerente = new Gerente(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]),
							Integer.parseInt(dados[5]), Double.parseDouble(dados[6]), Integer.parseInt(dados[7]));

					Usuario.mapaUsuarios.put(dados[2], gerente);
					Usuario.OrdenaUsuarios.put(dados[1], gerente);

				}
			} else {
				break;
			}
		}
		buffRead.close();
	}

	public static void comprovanteSaque(Conta conta, double valorSaque) throws IOException {

		String nomeArquivo = conta.getCpf() + "_" + conta.getNumeroAgencia() + "_" + conta.getNumeroConta()
				+ "_transacoes";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "*************** SAQUE ***************";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getNumeroAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumeroConta();
		buffWrite.append(linha + "\n");

		linha = "Valor: R$" + valorSaque;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "*************** FIM DO SAQUE ***************";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void comprovanteDeposito(Conta conta, double valorDeposito) throws IOException {

		String nomeArquivo = conta.getCpf() + "_" + conta.getNumeroAgencia() + "_" + conta.getNumeroConta()
				+ "_transacoes";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "*************** DEPOSITO ***************";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getNumeroAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumeroConta();
		buffWrite.append(linha + "\n");

		linha = "Valor: R$" + valorDeposito;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "*************** FIM DO DEPOSITO ***************";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void comprovanteTransferencia(Conta conta, Conta destino, double valorTransferencia)
			throws IOException {

		String nomeArquivo = conta.getCpf() + "_" + conta.getNumeroAgencia() + "_" + conta.getNumeroConta()
				+ "_conta_origem";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "*************** CONTA DESTINO ***************";
		buffWrite.append(linha + "\n");
		linha = "CPF: " + destino.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + destino.getNumeroAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + destino.getNumeroConta();
		buffWrite.append(linha + "\n");

		linha = "Valor: R$" + valorTransferencia;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "*************** FIM DA TRANSFERENCIA ***************";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void relatorioContasPorAgencia(Conta conta) throws IOException {

		String nomeArquivo = conta.getCpf() + "_" + conta.getNumeroAgencia() + "_" + conta.getNumeroConta()
				+ "_contas_por_agencia";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		int totalContas = 0;

		String linha = "********************** INFORMAÇÕES DO RESPONSÁVEL **********************";
		buffWrite.append(linha + "\n\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência : " + conta.getNumeroAgencia();
		buffWrite.append(linha + "\n");

		linha = "*******************************************************";
		buffWrite.append(linha + "\n\n");

		linha = "*************** TOTAL DE CONTAS NA MESMA AGÊNCIA ***************";
		buffWrite.append(linha + "\n\n");

		for (String cpf : Conta.mapaContas.keySet()) {
			if (Conta.mapaContas.get(cpf).getNumeroAgencia().equals(conta.getNumeroAgencia())) {

				linha = "CPF: " + Conta.mapaContas.get(cpf).getCpf();
				buffWrite.append(linha + "\n");

				linha = "Agência : " + Conta.mapaContas.get(cpf).getNumeroAgencia();
				buffWrite.append(linha + "\n");

				linha = "Conta: " + Conta.mapaContas.get(cpf).getNumeroConta();
				buffWrite.append(linha + "\n");

				totalContas++;

				linha = "**********************************";
				buffWrite.append(linha + "\n");
			}

		}

		linha = "Total de contas: " + totalContas;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "************************************************************************";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void relatorioContasGerenciadas(Conta conta) throws IOException {

		String nomeArquivo = conta.getCpf() + "_" + conta.getNumeroAgencia() + "_" + conta.getNumeroConta()
				+ "_contas_gerenciadas";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		int totalContas = 0;

		String linha = "********************** INFORMAÇÕES DO RESPONSÁVEL **********************";
		buffWrite.append(linha + "\n\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência : " + conta.getNumeroAgencia();
		buffWrite.append(linha + "\n");

		linha = "*******************************************************";
		buffWrite.append(linha + "\n\n");

		linha = "*************** TOTAL DE CONTAS NA MESMA AGÊNCIA ***************";
		buffWrite.append(linha + "\n\n");

		for (String cpf : Conta.mapaContas.keySet()) {
			if (Conta.mapaContas.get(cpf).getNumeroAgencia().equals(conta.getNumeroAgencia())) {

				linha = "CPF: " + Conta.mapaContas.get(cpf).getCpf();
				buffWrite.append(linha + "\n");

				linha = "Agência : " + Conta.mapaContas.get(cpf).getNumeroAgencia();
				buffWrite.append(linha + "\n");

				linha = "Conta: " + Conta.mapaContas.get(cpf).getNumeroConta();
				buffWrite.append(linha + "\n");

				totalContas++;

				linha = "**********************************";
				buffWrite.append(linha + "\n");
			}

		}

		linha = "Total de contas: " + totalContas;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "************************************************************************";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void relatorioTotalCapital(Conta conta, Map<String, Conta> mapaContas) throws IOException {

		String nomeArquivo = conta.getCpf() + "_" + conta.getNumeroAgencia() + "_" + conta.getNumeroConta()
				+ "_total_capital";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO, true));

		double saldoTotal = 0.0;

		String linha = "************************* TOTAL DE CAPITAL ARMAZENADO *************************";
		buffWrite.append(linha + "\n\n");

		for (String cpf : Conta.mapaContas.keySet()) {

			saldoTotal += Conta.mapaContas.get(cpf).getSaldo();

		}

		linha = "O total de capital armazenado no banco é de: R$" + saldoTotal;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "*******************************************************************************";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void relatorioTributacaoContaCorrente(Conta conta, Integer totalDep, Integer totalSaq)
			throws IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getNumeroAgencia() + "_" + conta.getNumeroConta()
				+ "_transacoes";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "*************** RELATORIO DE TRIBUTAÇÃO ***************";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getNumeroAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumeroConta();
		buffWrite.append(linha + "\n");

		linha = "O total gasto com operações: R$ " + ((ContaCorrente) conta).getTotalTributado();

		linha = "Valor Cobrado de cada saque: R$" + Taxas.SAQUE;
		buffWrite.append(linha + "\n");

		linha = "Total de saques realizados: " + ((ContaCorrente) conta).getTotalSaques();
		buffWrite.append(linha + "\n");

		linha = "Valor Cobrado de depósitos realizados: R$" + Taxas.DEPOSITO;
		buffWrite.append(linha + "\n");

		linha = "Total de depósitos realizados: " + ((ContaCorrente) conta).getTotalDepositos();
		buffWrite.append(linha + "\n");

		linha = "Valor Cobrado de cada transferência: R$" + Taxas.TRANSFERENCIA;
		buffWrite.append(linha + "\n");

		linha = "Total de transferências realizadas: " + ((ContaCorrente) conta).getTotalTransferencias();
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "*************** FIM DO RELATORIO DE TRIBUTAÇÃO ***************";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();
	}

	public static void relatorioRendimentoPoupanca(Conta conta, Double inputValor, Integer inputDias) throws ContaException, IOException {
		String nomeArquivo = conta.getCpf() + "_" + conta.getNumeroAgencia() + "_" + conta.getNumeroConta()
				+ "_transacoes";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO));

		String linha = "*************** RELATORIO DE RENDIMENTO POUPANÇA ***************";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getNumeroAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumeroConta();
		buffWrite.append(linha + "\n");

		linha = "A previsão de rendimento da sua conta: R$ " + ((ContaPoupanca) conta).previsaoDeRendimento(inputValor, inputDias);
		buffWrite.append(linha + "\n");
		

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "*************** FIM DO RELATÓRIO DE RENDIMENTO POUPANÇA ***************";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();
	};

}
