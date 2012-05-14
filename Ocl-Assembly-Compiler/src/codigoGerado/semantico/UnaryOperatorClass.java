package gerador.semantico;

public class UnaryOperatorClass{
	
	private String operator;

	public UnaryOperatorClass(Object operador) {
		this.operator = (String) operador;
	}

	public String getOperador() {
		return this.operator;
	}
}