package gerador.semantico;

import gerador.parser.Classe;

public class ParamOptClass {
	
	private Classe tipo;
	
	public ParamOptClass(Object n, Object ts, Object po) {
		String name = (String) n;
		TypeSpecifierClass typeSpec = (TypeSpecifierClass) ts;
		ParamOptClass paramOpt = (ParamOptClass) po;
		
		if(po == null) {
			this.tipo = typeSpec.getTipo();
		}else {
			this.tipo = paramOpt.getTipo();
		}
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
	
}
