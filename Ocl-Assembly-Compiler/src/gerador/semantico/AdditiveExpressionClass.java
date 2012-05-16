package gerador.semantico;

import gerador.parser.Classe;

public class AdditiveExpressionClass{
	
	private Classe tipo;
	
	public AdditiveExpressionClass(Object multiExp, Object OptAddExp){
		MultiplicativeExpressionClass multi = (MultiplicativeExpressionClass) multiExp;
		AdditiveExpressionOptClass optAdd = (AdditiveExpressionOptClass) OptAddExp;
		if(optAdd == null){
			this.tipo = multi.getTipo();
		}
		else{
			this.tipo = optAdd.getTipo();
		}
	}
	
	
	public Classe getTipo(){
		return this.tipo;
	}
	
}