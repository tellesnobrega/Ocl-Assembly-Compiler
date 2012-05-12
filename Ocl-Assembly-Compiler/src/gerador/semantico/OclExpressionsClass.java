package gerador.semantico;

public class OclExpressionsClass {

	private String tipo;
	private String codigo;
	
	public OclExpressionsClass(Object constraint, Object oclExpressions){
		ConstraintClass cons = (ConstraintClass) constraint;
		OclExpressionsClass o = (OclExpressionsClass) oclExpressions;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

}
