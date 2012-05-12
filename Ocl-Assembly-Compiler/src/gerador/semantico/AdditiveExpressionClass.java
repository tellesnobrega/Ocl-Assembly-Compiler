package gerador.semantico;

import gerador.parser.Classe;

public class AdditiveExpressionClass{
	
	private Classe tipo;
	private String codigo;
	
	public AdditiveExpressionClass(Object multiExp, Object OptAddExp){
		MultiplicativeExpressionClass multi = (MultiplicativeExpressionClass) multiExp;
		OptAdditiveExpressionClass optAdd = (OptAdditiveExpressionClass) OptAddExp;
		if(optAdd == null){
			this.tipo = multi.getTipo();
			this.codigo = multi.getCodigo();
		}
		else{
			this.tipo = optAdd.getTipo();
			this.codigo = multi.getCodigo() + optAdd.getCodigo();
		}
	}
	
	
	public Classe getTipo(){
		return this.tipo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
		
}