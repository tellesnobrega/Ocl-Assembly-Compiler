package gerador.semantico;

import gerador.parser.Classe;

public class ContextDeclarationOptClass {
	
	private Classe tipo;
	private String codigo;
	
	public ContextDeclarationOptClass(Object opCon) {
		OperationContextClass opContext = (OperationContextClass) opCon;
		this.codigo = opContext.getCodigo();
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
