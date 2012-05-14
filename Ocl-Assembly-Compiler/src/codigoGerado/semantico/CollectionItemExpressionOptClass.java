package gerador.semantico;

import gerador.parser.Classe;

public class CollectionItemExpressionOptClass {
	
	private String codigo;
	private Classe tipo;
	
	public CollectionItemExpressionOptClass(Object exp) {
		ExpressionClass expression = (ExpressionClass) exp;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Classe getTipo() {
		return tipo;
	}
	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
