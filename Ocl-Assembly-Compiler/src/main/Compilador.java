package main;

import java.io.FileReader;
import java.io.IOException;

import codigoGerado.AnalisadorLexico;
import codigoGerado.parser;


public class Compilador {
	
	public static void executaAnalisadorLexico(String exemplo) throws IOException {
		AnalisadorLexico scanner = new AnalisadorLexico(new FileReader(exemplo));
		while (scanner.YYEOF != 1) {
			scanner.next_token();
		}
	}
	
	public static void executaAnalisadorSintatico(String exemplo) throws Exception {
		System.out.println("Analise Lexica");
		AnalisadorLexico scanner = new AnalisadorLexico(new FileReader(exemplo));
		System.out.println("Analise Lexica Concluida");
		System.out.println("Analise Sintatico");
		parser p = new parser(scanner);
		p.parse();
		System.out.println("Analise Sintatica Concluida");
	}
}