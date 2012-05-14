package gerador.semantico;

import java.util.jar.Attributes.Name;

import gerador.parser.Classe;

public class NameOptClass {
	
	private String codigo;
	private Classe tipo;
	
	public NameOptClass(Object n, Object nameOpt) {
		String name = (String) n;
		NameOptClass nOpt = (NameOptClass) nameOpt;
	}
	
	public NameOptClass(Object name) {
		NameOpt2Class nameOpt = (NameOpt2Class) name;
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
