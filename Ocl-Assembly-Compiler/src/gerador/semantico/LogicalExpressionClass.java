package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class LogicalExpressionClass {

	private Classe tipo;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();

	public LogicalExpressionClass(Object relationalExpression) {
		RelationalExpressionClass relExp = (RelationalExpressionClass) relationalExpression;
		this.tipo = relExp.getTipo();
	}
	
	public LogicalExpressionClass(Object re, Object lo, Object re2) {
		RelationalExpressionClass relExp = (RelationalExpressionClass) re;
		LogicalOperatorClass logOp = (LogicalOperatorClass) lo;
		RelationalExpressionClass relExp2 = (RelationalExpressionClass) re2;
		
		this.tipo = analisador.getGerenciador().getClasse("Boolean");
		
		
	}


	public Classe getTipo() {
		return tipo;
	}
}
