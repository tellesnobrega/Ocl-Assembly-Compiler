package gerador.semantico;

import gerador.parser.Classe;

public class PrimaryExpressionClass {
	
	private Classe tipo;
	private String codigo;
	
	public PrimaryExpressionClass(Object objeto, String tipo){
		if(tipo.equals("literalCollectionClass")) {
			this.tipo = ((LiteralCollectionClass) objeto).getTipo();
		}
		if (tipo.equals("literal")) {
			this.tipo = ((LiteralClass) objeto).getTipo();
			this.codigo = ((LiteralClass) objeto).getCodigo();
		}
		if(tipo.equals("propertyCall")) {
			this.tipo = ((PropertyCallClass) objeto).getTipo();
			this.codigo = ((PropertyCallClass) objeto).getCodigo();
		}
		if (tipo.equals("expression")) {
			this.tipo = ((ExpressionClass) objeto).getTipo();
			this.codigo = "(" + ((ExpressionClass) objeto).getCodigo() + ")";
		}
		if (tipo.equals("IfExpressionClass")) {
			this.tipo = ((IfExpressionClass) objeto).getTipo();
			this.codigo = ((IfExpressionClass) objeto).getCodigo();
		}
	}
	
	public Classe getTipo(){
		return this.tipo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}
	