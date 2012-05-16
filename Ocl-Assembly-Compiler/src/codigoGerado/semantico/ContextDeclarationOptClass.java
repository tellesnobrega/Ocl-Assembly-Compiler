package gerador.semantico;

import gerador.parser.Classe;

public class ContextDeclarationOptClass {
	
	private Classe tipo;
	
	public ContextDeclarationOptClass(Object opCon) {
		OperationContextClass opContext = (OperationContextClass) opCon;
		
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
