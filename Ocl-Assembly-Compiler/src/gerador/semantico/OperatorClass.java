package gerador.semantico;

public class OperatorClass {
	
	private String operator;
	
	public OperatorClass(Object operador) {
		this.operator = (String) operador;
		
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	

}
