package gerador.semantico;

public class RelationalOperatorClass{

	private String operador;
	
	public RelationalOperatorClass(Object operador) {
		this.operador = (String) operador;
	}

	public String getOperador() {
		return operador;
	}
}