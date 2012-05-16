package gerador.semantico;

import gerador.parser.Classe;

public class ContextDeclarationClass {

	private Classe tipo;

	public ContextDeclarationClass(Object cdo) {
		ContextDeclarationOptClass contexDecOpt = (ContextDeclarationOptClass) cdo;
		
	}


	public Classe getTipo() {
		return tipo;
	}
}
