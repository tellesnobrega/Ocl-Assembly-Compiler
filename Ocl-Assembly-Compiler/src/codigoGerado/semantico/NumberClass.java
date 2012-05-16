package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class NumberClass {

	private Classe tipo;
	
	
	public NumberClass(Object ob, String type) {
		AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
		this.tipo = analisador.getGerenciador().getClasse(type);
	}
	
	public Classe getTipo() {
		return tipo;
	}
}
