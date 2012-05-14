package gerador.semantico;

import gerador.parser.Classe;

public class PropertyOptCallClass {
	private Classe tipo;
	private String codigo;
	
	public PropertyOptCallClass(Object pcp) {
		PropertyCallParametersClass property = (PropertyCallParametersClass) pcp;
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
