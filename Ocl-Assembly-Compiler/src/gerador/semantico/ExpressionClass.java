package gerador.semantico;

import gerador.parser.Classe;

public class ExpressionClass {

	private Classe tipo;
	private String codigo;

	public ExpressionClass(Object logicExpression) {
		LogicalExpressionClass logExp = (LogicalExpressionClass) logicExpression;
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
