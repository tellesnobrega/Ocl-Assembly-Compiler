package gerador.semantico;

import gerador.parser.Classe;

public class PostfixExpressionClass {

	private Classe tipo;
	
	public PostfixExpressionClass(Object priExp, Object postExpOpt) {
		PrimaryExpressionClass primaryExp = (PrimaryExpressionClass) priExp;
		PostFixExpressionOptClass peo = (PostFixExpressionOptClass) postExpOpt;
		
		if (peo == null) {
			this.tipo = primaryExp.getTipo();
		} else {
			this.tipo = peo.getTipo();
		}
		
	}

	public Classe getTipo() {
		return tipo;
	}
}
