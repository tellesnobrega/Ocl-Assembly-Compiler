package gerador.semantico;

import gerador.parser.Classe;

public class CollectionItemClass {

	private Classe tipo;

	public CollectionItemClass(Object exp, Object colItemOpt) {
		ExpressionClass expression = (ExpressionClass) exp;
		CollectionItemExpressionOptClass collectionItemExpOpt = (CollectionItemExpressionOptClass) colItemOpt;
		if(collectionItemExpOpt == null){
			this.tipo = expression.getTipo();
		}
		else{
			this.tipo = collectionItemExpOpt.getTipo();
		}
	}


	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
}
