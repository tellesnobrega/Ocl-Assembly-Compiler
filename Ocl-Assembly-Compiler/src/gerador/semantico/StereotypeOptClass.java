package gerador.semantico;
public class StereotypeOptClass {

	private String tipo;
	private String codigo;

	public StereotypeOptClass(Object s, Object sn, Object oclE, Object sOpt) {
		StereotypeClass stereotype = (StereotypeClass) s;
		StereotypeNameClass sName = (StereotypeNameClass) sn;
		OclExpressionClass oclExp = (OclExpressionClass) oclE;
		StereotypeOptClass stereotypeOpt = (StereotypeOptClass) sOpt;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}
}
