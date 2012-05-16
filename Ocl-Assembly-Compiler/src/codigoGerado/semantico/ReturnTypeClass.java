package gerador.semantico;

import gerador.parser.Classe;

public class ReturnTypeClass {
	
	private Classe tipo;
	
	public ReturnTypeClass(Object ts) {
		TypeSpecifierClass typeSpec = (TypeSpecifierClass) ts;
		this.tipo = typeSpec.getTipo();
	}
	
	public Classe getTipo() {
		return tipo;
	}
	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
