package gerador.semantico;

import gerador.parser.Classe;

public class ContextDeclarationClass {

	private Classe tipo;
	private String codigo;

	public ContextDeclarationClass(Object classifierContext) {
		codigo = ((ClassifierContextClass) classifierContext).getCodigo();
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
