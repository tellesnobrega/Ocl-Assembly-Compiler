package gerador.semantico;

import gerador.parser.Classe;

public class PostfixExpressionClass {

	private Classe tipo;
	private String codigo;
	
	public PostfixExpressionClass(Object priExp, Object postExpOpt) {
		PrimaryExpressionClass primaryExp = (PrimaryExpressionClass) priExp;
		PostFixExpressionOptClass peo = (PostFixExpressionOptClass) postExpOpt;
		
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
