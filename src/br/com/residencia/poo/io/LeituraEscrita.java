package br.com.residencia.poo.io;

import static java.lang.Integer.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.residencia.poo.contas.Conta;
import br.com.residencia.poo.contas.ContaCorrente;
import br.com.residencia.poo.contas.ContaPoupanca;

public class LeituraEscrita {
	public static void main(String[] args) {
	try (BufferedReader br = new BufferedReader(new FileReader("./temp/teste.txt"))) {
        String line = br.readLine();
        while (line != null) {
        	StringBuilder output = new StringBuilder();
        	String[] pieces = line.split("\\;");
        	
        	for(String piece : pieces) {
        		List pow = new ArrayList();
        		//System.out.println(piece);
        		String [] doublePieces = piece.split("\\,");
        		for(String doublePiece : doublePieces) {
        			//System.out.println(doublePiece);
        			if(doublePiece.equals("Corrente")||doublePiece.equals("Poupanca")) {
        				pow.add(doublePiece);
        			}else {
        				int x = parseInt(doublePiece);
        				pow.add(doublePiece);
        			}
        		}
        		if(pow.get(0).toString() != null && pow.get(0).toString().equals("Corrente")) {
        			ContaCorrente newC = new ContaCorrente(pow.get(1).toString(),pow.get(2).toString());
        			System.out.println(newC);
        		}else if(pow.get(0).toString()!=null && pow.get(0).toString().equals("Poupanca")) {
        			Conta newP = new ContaPoupanca(pow.get(1).toString(),pow.get(2).toString());
        			System.out.println(newP);
        		}
        		
        		
        	line = br.readLine();
        }
    }} catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

}
