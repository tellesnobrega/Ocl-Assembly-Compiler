package gerador.semantico;

public class MultiplyOperatorClass{
	private String operador;
	
	public MultiplyOperatorClass(Object operador) {
		this.setOperador((String) operador);
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}
	
}