package br.com.residencia.poo.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.residencia.poo.contas.Conta;

public class LeituraEscrita {

//	private static final String PATH_BASICO = "./temp/";
//	private static final String EXTENSAO = "comprovantesSaque.txt";

	public static void comprovanteSaque(Conta conta, double valorSaque) throws IOException {
	
	String nomeArquivo = conta.getCpf() + "_" + conta.getNumeroAgencia() + "_" + conta.getNumeroConta() + " transacoes";
	
	BufferedWriter bffWrite = new BufferedWriter(new FileWriter("./temp/comprovantesSaque.txt"));
			
	String linha = "จจจจจจจจจจจจ COMPROVANTE DE SAQUE จจจจจจจจจจจจ";
	Writer buffWrite;
	buffWrite.append(linha + "\n");
	
	linha =  "CPF" + conta.getCpf();
	buffWrite.append(linha + "\n");

	linha =  "Ag๊ncia" + conta.getNumeroAgencia();
	buffWrite.append(linha + "\n");

	linha =  "Conta" + conta.getNumeroConta();
	buffWrite.append(linha + "\n");

	linha =  "Valor; R$" + valorSaque;
	buffWrite.append(linha + "\n");

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy  HH:MM:ss");
	Date date = new Date();
	buffWrite.append("Opera็ใo realizada em: " + simpleDateFormat.format(date));

	linha = "จจจจจจจจจจจจ VOLTE SEMPRE จจจจจจจจจจจจ";
	buffWrite.append(linha + "\n\n");

	buffWrite.close();
	
	}

}
