package gerador.semantico;

import gerador.parser.Classe;

public class MultiplicativeExpressionClass{

	private Classe tipo;
	private String codigo;
	
	public MultiplicativeExpressionClass(Object unaryExp ){
		UnaryExpressionClass unary = (UnaryExpressionClass) unaryExp;
		//Tem mais coisas pra fazer aqui (de acordo com o de S), mas nao sei nem pra onde vai. Wagner.
		if(unary != null){
			this.tipo = unary.getTipo();
			this.codigo = unary.getCodigo();
		}
	}
	
	public Classe getTipo(){
		return this.tipo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}