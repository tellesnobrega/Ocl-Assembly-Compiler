package gerador.semantico;


public class OclExpressionsClass {

	private String tipo;
	private String codigo;
	
	public OclExpressionsClass(Object expressions){
		ExpressionClass e = (ExpressionClass) expressions;
//		AnalisadorSemantico.getInstance().saida.println(cons.getCodigo() + Util.QUEBRA_DE_LINHA);
		
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

}
