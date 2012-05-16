package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class BooleanClass {
	
	private Classe tipo;
	
	public BooleanClass(Object m) {
		AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
		this.tipo = analisador.getGerenciador().getClasse("Boolean");
	}
	

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
