package gerador.semantico;

import gerador.parser.Classe;

public class NameOpt2 {
	
	private String codigo;
	private Classe tipo;
	
	public NameOpt2(Object name) {
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
