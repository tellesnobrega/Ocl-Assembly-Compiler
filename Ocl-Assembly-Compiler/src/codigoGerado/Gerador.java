package gerador;

import java.io.IOException;

import java_cup.internal_error;

public class Gerador {
	public static void gerarAnalisadorLexico() {
		String[] path = {Path.ANALISADOR_LEXICO_PATH, "-d", Path.CODIGO_GERADO_PATH};
		JFlex.Main.main(path);
	}
	
	public static void gerarAnalisadorSintatico() throws internal_error, IOException, Exception {
		String[] path = {"-package", "codigoGerado", "-destdir", Path.CODIGO_GERADO_PATH, Path.ANALISADOR_SINTATICO_PATH};
		java_cup.Main.main(path);
	}

	public static void main(String[] args) throws internal_error, IOException, Exception {
		gerarAnalisadorLexico();
		gerarAnalisadorSintatico();
	}
}