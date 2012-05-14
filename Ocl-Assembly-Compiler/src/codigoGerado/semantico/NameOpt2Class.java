package gerador.semantico;

import gerador.parser.Classe;

public class NameOpt2Class {
	
	private String codigo;
	private Classe tipo;
	
	public NameOpt2Class(Object name) {
		String n = (String) name;
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
