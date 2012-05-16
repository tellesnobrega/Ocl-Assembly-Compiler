package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class OclExpressionClass {

	private Classe tipo;
	
	public OclExpressionClass(Object exp) {
		ExpressionClass expression = (ExpressionClass) exp;
		this.tipo = expression.getTipo();
	}
	

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
