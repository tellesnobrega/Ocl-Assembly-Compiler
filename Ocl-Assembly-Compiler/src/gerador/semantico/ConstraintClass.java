package gerador.semantico;
public class ConstraintClass {

	private String tipo;

	public ConstraintClass(Object cd, Object s, Object n, Object oclE, Object sOpt) {
		ContextDeclarationClass contextDeclaration = (ContextDeclarationClass) cd;
		StereotypeClass stereotype = (StereotypeClass) s;
		String name = (String) n;
		OclExpressionClass oclExp = (OclExpressionClass) oclE;
		StereotypeOptClass stereotypeOpt = (StereotypeOptClass) sOpt;
		
	}
	
	public ConstraintClass(Object cd, Object s, Object oclE, Object sOpt) {
		ContextDeclarationClass contextDeclaration = (ContextDeclarationClass) cd;
		StereotypeClass stereotype = (StereotypeClass) s;
		OclExpressionClass oclExp = (OclExpressionClass) oclE;
		StereotypeOptClass stereotypeOpt = (StereotypeOptClass) sOpt;
		
	}

	public String getTipo() {
		return tipo;
	}
}
