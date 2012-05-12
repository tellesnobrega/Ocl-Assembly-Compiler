package gerador.semantico;

import gerador.parser.Classe;

public class LogicalExpressionClass {

	private Classe tipo;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
	private String codigo;

	public LogicalExpressionClass(Object relationalExpression, Object manyLogicalExpression) {
		RelationalExpressionClass relExp = (RelationalExpressionClass) relationalExpression;
		ManyLogicalExpressionClass manyLogExp = (ManyLogicalExpressionClass) manyLogicalExpression;
		if (manyLogicalExpression == null) {
			this.tipo = relExp.getTipo();
			this.codigo = relExp.getCodigo();
		} else {
			this.tipo = analisador.getGerenciador().getClasse("Boolean");
			if (analisador.getLogicalOperator().equals("implies")) {
				this.codigo = "(True if not (" + relExp.getCodigo() + ") else (" + manyLogExp.getCodigo() + "))";
			} else {
				this.codigo = relExp.getCodigo() + manyLogExp.getCodigo();
			}
		}
	}
	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
