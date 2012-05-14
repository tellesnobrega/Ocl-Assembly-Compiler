package gerador.semantico;

import gerador.parser.Classe;

public class OperationNameClass {
	
	private String codigo;
	private Classe tipo;
	
	public OperationNameClass(Object entrada) {
		this.codigo = ((String) entrada);
	}
	
	public Classe getTipo() {
		return tipo;
	}
	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
