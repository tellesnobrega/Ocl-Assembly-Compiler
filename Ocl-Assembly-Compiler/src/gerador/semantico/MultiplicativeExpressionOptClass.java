package gerador.semantico;

import gerador.parser.Classe;

public class MultiplicativeExpressionOptClass {

	private String codigo;
	private Classe tipo;
	
	public MultiplicativeExpressionOptClass(Object multExpOpt, Object multOp, Object uExp) {
		MultiplicativeExpressionOptClass multExp = (MultiplicativeExpressionOptClass) multExpOpt;
		MultiplyOperatorClass mo = (MultiplyOperatorClass) multOp;
		UnaryExpressionClass unary = (UnaryExpressionClass) uExp;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Classe getTipo() {
		return tipo;
	}
	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
	
}
