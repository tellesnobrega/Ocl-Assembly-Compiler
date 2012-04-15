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
		System.out.println("Iniciando analisador Lexico!");
		AnalisadorLexico scanner = new AnalisadorLexico(new FileReader(exemplo));
		System.out.println("Analise Lexica: DONE!");
		System.out.println("Iniciando analisador Sintatico!");
		parser p = new parser(scanner);
		p.parse();
		System.out.println("Analise Sintatica: DONE!");
		System.out.println("Analise bem sucedida, nenhum erro foi encontrado!");
	}
}