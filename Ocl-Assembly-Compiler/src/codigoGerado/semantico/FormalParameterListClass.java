package gerador.semantico;

import gerador.parser.Classe;

public class FormalParameterListClass {
	
	private Classe tipo;
	
	public FormalParameterListClass(Object n,Object ts, Object po) {
		String name = (String) n;
		TypeSpecifierClass typeSpec = (TypeSpecifierClass) ts;
		ParamOptClass paramOpt = (ParamOptClass) po;
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
