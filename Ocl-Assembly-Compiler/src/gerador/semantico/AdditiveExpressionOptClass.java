package gerador.semantico;

import gerador.parser.Classe;

public class AdditiveExpressionOptClass {
	
	private Classe tipo;
	private String codigo;
	
	public AdditiveExpressionOptClass(Object addOpt, Object addOp, Object multiExp){
		MultiplicativeExpressionClass multi = (MultiplicativeExpressionClass) multiExp;
		AdditiveExpressionOptClass optAdd = (AdditiveExpressionOptClass) addOpt;
		AddOperatorClass addOperator = (AddOperatorClass) addOp;
		//TODO Consertar
		if(optAdd == null){
			this.setTipo(multi.getTipo());
			this.setCodigo(multi.getCodigo());
		}
		else{
			this.setTipo(this.getTipo());
			this.setCodigo(multi.getCodigo() + this.getCodigo());
		}
	}

	public Classe getTipo() {
		return tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
