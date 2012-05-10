package main;

import gerador.parser.TradutorXMI;
import java_cup.internal_error;

public class Main {
	
	public static void executaAnalisadores(String ocl, String uml) throws Exception {
		TradutorXMI.getInstance().traduz(uml);
		Compilador.executaAnalisadorSintatico(ocl);
	}

	public static void main(String[] args) throws internal_error, Exception {
		
		if (args.length == 0) {
			try {
				String arquivoOcl = "teste.txt";
				String arquivoXml = "profe_modificado.xml";
				executaAnalisadores(arquivoOcl, arquivoXml);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				executaAnalisadores(args[0], args[1]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}