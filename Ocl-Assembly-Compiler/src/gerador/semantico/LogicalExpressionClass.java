package gerador.semantico;

import gerador.parser.Classe;

public class LogicalExpressionClass {

	private Classe tipo;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
	private String codigo;

	public LogicalExpressionClass(Object relationalExpression) {
		RelationalExpressionClass relExp = (RelationalExpressionClass) relationalExpression;
		this.tipo = analisador.getGerenciador().getClasse("Boolean");
		if (analisador.getLogicalOperator().equals("implies")) {
			this.codigo = "(True if not (" + relExp.getCodigo() + ") ";
		} else {
			this.codigo = relExp.getCodigo();
		}
	}
	
	public LogicalExpressionClass(Object re, Object lo, Object re2) {
		RelationalExpressionClass relExp = (RelationalExpressionClass) re;
		LogicalOperatorClass logOp = (LogicalOperatorClass) lo;
		RelationalExpressionClass relExp2 = (RelationalExpressionClass) re2;
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
