package gerador.semantico;

import gerador.parser.Classe;

public class ExpressionClass {

	private Classe tipo;

	public ExpressionClass(Object logicExpression) {
		LogicalExpressionClass logExp = (LogicalExpressionClass) logicExpression;
		this.tipo = logExp.getTipo();
	}


	public Classe getTipo() {
		return tipo;
	}
}
