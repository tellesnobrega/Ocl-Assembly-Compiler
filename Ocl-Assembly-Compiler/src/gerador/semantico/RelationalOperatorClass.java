package gerador.semantico;

public class RelationalOperatorClass implements OperatorInterface{

	private String operador;
	
	public RelationalOperatorClass(Object operador) {
		this.operador = (String) operador;
	}

	@Override
	public String getOperador() {
		return operador;
	}
}