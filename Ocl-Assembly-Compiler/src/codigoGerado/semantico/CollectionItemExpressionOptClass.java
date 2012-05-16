package gerador.semantico;

import gerador.parser.Classe;

public class CollectionItemExpressionOptClass {
	
	private Classe tipo;
	
	public CollectionItemExpressionOptClass(Object exp) {
		ExpressionClass expression = (ExpressionClass) exp;
		if(expression != null) {
			this.tipo = expression.getTipo();
		}
	}
	
	public Classe getTipo() {
		return tipo;
	}
	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
