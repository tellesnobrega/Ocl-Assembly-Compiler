package gerador.semantico;

import gerador.parser.Classe;

public class ReturnTypeClass {
	
	private String codigo;
	private Classe tipo;
	
	public ReturnTypeClass(Object ts) {
		TypeSpecifierClass typeSpec = (TypeSpecifierClass) ts;
	}
	
	public Classe getTipo() {
		return tipo;
	}
	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
