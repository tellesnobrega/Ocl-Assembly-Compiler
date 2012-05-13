package gerador.semantico;

import gerador.parser.Classe;

public class ContextDeclarationClass {

	private Classe tipo;
	private String codigo;

	public ContextDeclarationClass(Object cdo) {
		ContextDeclarationOptClass contexDecOpt = (ContextDeclarationOptClass) cdo;
		
		this.codigo = "context " + contexDecOpt.getCodigo(); 
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
