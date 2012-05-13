package gerador.semantico;

import java.util.jar.Attributes.Name;

import gerador.parser.Classe;

public class NameOpt {
	
	private String codigo;
	private Classe tipo;
	
	public NameOpt(Object n, Object nameOpt) {
		String name = (String) n;
		NameOpt nOpt = (NameOpt) nameOpt;
	}
	
	public NameOpt(Object name) {
		NameOpt2 nameOpt = (NameOpt2) name;
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
