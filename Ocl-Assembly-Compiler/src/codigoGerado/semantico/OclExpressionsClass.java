package gerador.semantico;


public class OclExpressionsClass {

	private String tipo;
	
	public OclExpressionsClass(Object c, Object oclE){
		ConstraintClass e = (ConstraintClass) c;
		OclExpressionsClass oclExps = (OclExpressionsClass) oclE;
	}


	public String getTipo() {
		return tipo;
	}

}
