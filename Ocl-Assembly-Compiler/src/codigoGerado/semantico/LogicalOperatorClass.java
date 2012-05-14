package gerador.semantico;

public class LogicalOperatorClass {	
	private String operator;
	
	public LogicalOperatorClass(Object operador) {
		this.operator = (String) operador;
	}
	
	
	public String getOperador() {
		return this.operator;
	}
}