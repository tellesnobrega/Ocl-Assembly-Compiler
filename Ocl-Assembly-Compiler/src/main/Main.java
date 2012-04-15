package main;

import java_cup.internal_error;

public class Main {

	public static void main(String[] args) throws internal_error, Exception {
		Compilador.executaAnalisadorSintatico(args[0]);
	}
}