package gerador.semantico;

public class SimpleTypeSpecifierOptClass implements OperatorInterface{

	private String operador;
	
	public SimpleTypeSpecifierOptClass(Object operador) {
		this.operador = (String) operador;
	}

	@Override
	public String getOperador() {
		return operador;
	}
}