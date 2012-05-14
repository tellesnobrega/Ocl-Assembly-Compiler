package gerador.semantico;

import gerador.parser.Classe;

public class UnaryExpressionClass {

	private Classe tipo;
	private String codigo;
	
	public UnaryExpressionClass(Object unaryOper, Object postFixExp){
		UnaryOperatorClass unaryOp = (UnaryOperatorClass) unaryOper;
		PostfixExpressionClass postFixEx = (PostfixExpressionClass) postFixExp;
		
	}
	
	public UnaryExpressionClass(Object postFixExp) {
		PostfixExpressionClass postFixEx = (PostfixExpressionClass) postFixExp;
		
		this.tipo = postFixEx.getTipo();
		this.codigo = postFixEx.getCodigo();
	}
	
	
	public String getCodigo(){
		return this.codigo;
	}

	public Classe getTipo() {
		return tipo;
	}

}