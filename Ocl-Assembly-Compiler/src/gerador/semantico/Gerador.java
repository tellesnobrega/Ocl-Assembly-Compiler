package gerador.semantico;

import java.io.IOException;

import java_cup.internal_error;

public class Gerador {
	public static void gerarAnalisadorLexico() {
		String[] path = {Constant.ANALISADOR_LEXICO_PATH, "-d", Constant.CODIGO_GERADO_PATH};
		JFlex.Main.main(path);
	}
	
	public static void gerarAnalisadorSintatico() throws internal_error, IOException, Exception {
		String[] path = {"-package", "codigoGerado", "-destdir", Constant.CODIGO_GERADO_PATH, Constant.ANALISADOR_SINTATICO_PATH};
		java_cup.Main.main(path);
	}
	
	public static void main(String[] args) throws internal_error, IOException, Exception {
		gerarAnalisadorLexico();
		gerarAnalisadorSintatico();
	}
}
