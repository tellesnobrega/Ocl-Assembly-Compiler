package gerador.semantico;

import gerador.parser.Classe;

public class FormalParameterListClass {
	
	private Classe tipo;
	private String codigo;
	
	public FormalParameterListClass(Object n,Object ts, Object po) {
		String name = (String) n;
		TypeSpecifierClass typeSpec = (TypeSpecifierClass) ts;
		ParamOptClass paramOpt = (ParamOptClass) po;
		this.codigo = name + ":" + typeSpec.getCodigo() + paramOpt.getCodigo();
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
