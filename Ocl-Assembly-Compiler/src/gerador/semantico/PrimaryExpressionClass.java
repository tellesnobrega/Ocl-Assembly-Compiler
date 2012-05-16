package gerador.semantico;

import gerador.parser.Classe;

public class PrimaryExpressionClass {
	
	private Classe tipo;
	
	public PrimaryExpressionClass(int linha, int coluna, Object objeto, String tipo) throws Exception{
		if(tipo.equals("literalCollectionClass")) {
			this.tipo = ((LiteralCollectionClass) objeto).getTipo();
		}else if (tipo.equals("literal")) {
			this.tipo = ((LiteralClass) objeto).getTipo();
		}else if(tipo.equals("propertyCall")) {
			this.tipo = ((PropertyCallClass) objeto).getTipo();
		}else if (tipo.equals("expression")) {
			this.tipo = ((ExpressionClass) objeto).getTipo();
		}else  if (tipo.equals("IfExpressionClass")) {
			this.tipo = ((IfExpressionClass) objeto).getTipo();
		} else {
			throw new Exception("Tipo nao suportado na linha: " + linha + " e coluna: " + coluna);
		}
	}
	
	public Classe getTipo(){
		return this.tipo;
	}
	
}
	