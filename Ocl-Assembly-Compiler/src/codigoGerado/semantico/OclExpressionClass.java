package gerador.semantico;

public class OclExpressionClass {

	String codigo;
	
	public OclExpressionClass(Object exp) {
		ExpressionClass expression = (ExpressionClass) exp;
	}
	
	public String getCodigo() {
		return codigo;
	}

}
