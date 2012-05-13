package gerador.semantico;
public class ConstraintClass {

	private String tipo;
	private String codigo;

	public ConstraintClass(Object cd, Object s, Object n, Object oclE, Object sOpt) {
		ContextDeclarationClass contextDeclaration = (ContextDeclarationClass) cd;
		StereotypeClass stereotype = (StereotypeClass) s;
		String name = (String) n;
		OclExpressionClass oclExp = (OclExpressionClass) oclE;
		StereotypeOptClass stereotypeOpt = (StereotypeOptClass) sOpt;
		
//		this.codigo = 
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}
}
