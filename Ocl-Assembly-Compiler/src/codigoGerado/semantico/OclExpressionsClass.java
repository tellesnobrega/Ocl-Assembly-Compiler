package gerador.semantico;


public class OclExpressionsClass {

	private String tipo;
	private String codigo;
	
	public OclExpressionsClass(Object expressions, Object oclE){
		ExpressionClass e = (ExpressionClass) expressions;
		OclExpressionsClass oclExps = (OclExpressionsClass) oclE;
//		AnalisadorSemantico.getInstance().saida.println(cons.getCodigo() + Util.QUEBRA_DE_LINHA);
		
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

}
