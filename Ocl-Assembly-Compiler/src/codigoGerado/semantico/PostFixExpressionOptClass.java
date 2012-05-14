package gerador.semantico;

import gerador.parser.Classe;

public class PostFixExpressionOptClass {

	private String codigo;
	private Classe tipo;
	
	public PostFixExpressionOptClass(Object postExpOpt,Object op,Object proCall) {
		PostFixExpressionOptClass postExp = (PostFixExpressionOptClass) postExpOpt;
		OperatorClass operator = (OperatorClass) op;
		PropertyCallClass propCall = (PropertyCallClass) proCall;
		
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
