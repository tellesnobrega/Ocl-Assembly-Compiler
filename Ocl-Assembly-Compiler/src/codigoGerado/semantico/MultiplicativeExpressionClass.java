package gerador.semantico;

import gerador.parser.Classe;

public class MultiplicativeExpressionClass{

	private Classe tipo;
	private String codigo;
	
	public MultiplicativeExpressionClass(Object unaryExp, Object multExpOpt ){
		UnaryExpressionClass unary = (UnaryExpressionClass) unaryExp;
		MultiplicativeExpressionOptClass mult = (MultiplicativeExpressionOptClass) multExpOpt;
		if(unary != null){
			this.tipo = unary.getTipo();
			this.codigo = unary.getCodigo() + mult.getCodigo();
		}
		else {
			this.tipo = mult.getTipo();
			this.codigo = mult.getCodigo();
		}
		
	}
	
	public Classe getTipo(){
		return this.tipo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}