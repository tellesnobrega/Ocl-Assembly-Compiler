package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class LiteralClass {

	private Classe tipo;

	public LiteralClass(Object literal) throws Exception {
		if (literal instanceof BooleanClass) {
			this.tipo = ((BooleanClass) literal).getTipo();
		} else if (literal instanceof NumberClass) {
			this.tipo = ((NumberClass) literal).getTipo();
		} else {
			throw new Exception("Erro!");
		}
	}
	
	public LiteralClass(Object literal, Object tipo) {
		AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
		this.tipo = analisador.getGerenciador().getClasse(((String) tipo));
	}


	public Classe getTipo() {
		return tipo;
	}
}
