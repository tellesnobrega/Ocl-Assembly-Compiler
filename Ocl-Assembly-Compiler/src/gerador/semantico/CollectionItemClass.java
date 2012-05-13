package gerador.semantico;

import gerador.parser.Classe;

public class CollectionItemClass {

	private Classe tipo;
	private String codigo;

	public CollectionItemClass(Object exp, Object colItemOpt) {
		ExpressionClass expression = (ExpressionClass) exp;
		CollectionItemExpressionOptClass collectionItemExpOpt = (CollectionItemExpressionOptClass) colItemOpt;
		if(collectionItemExpOpt == null){
			this.tipo = expression.getTipo();
			this.codigo = expression.getCodigo();
		}
		else{
			this.tipo = collectionItemExpOpt.getTipo();
			this.codigo = expression.getCodigo() + collectionItemExpOpt.getCodigo();
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
}
