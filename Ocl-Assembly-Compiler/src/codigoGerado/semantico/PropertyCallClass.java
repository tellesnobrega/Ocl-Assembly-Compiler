package gerador.semantico;

import gerador.parser.Classe;

public class PropertyCallClass {

	private Classe tipo;
	private String codigo;

	public PropertyCallClass(int linha, int coluna, Object pn, Object opc) {
		PathNameClass path = (PathNameClass) pn;
		PropertyOptCallClass prop = (PropertyOptCallClass) opc;
		
	}
	
	public PropertyCallClass(Object a) {
		PathNameClass path = (PathNameClass) a;
	
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
