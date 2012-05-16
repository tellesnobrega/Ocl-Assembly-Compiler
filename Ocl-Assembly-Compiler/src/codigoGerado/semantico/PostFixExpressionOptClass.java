package gerador.semantico;

import gerador.parser.Classe;

public class PostFixExpressionOptClass {

	private Classe tipo;
	
	public PostFixExpressionOptClass(Object postExpOpt,Object op,Object proCall) {
		PostFixExpressionOptClass postExp = (PostFixExpressionOptClass) postExpOpt;
		OperatorClass operator = (OperatorClass) op;
		
		if (proCall instanceof PropertyCallClass) {
			PropertyCallClass propCall = (PropertyCallClass) proCall;
			if (postExp == null) {
				this.tipo = propCall.getTipo();
			} else {
				this.tipo = postExp.getTipo();
			}
		}
	}
	
	public Classe getTipo() {
		return tipo;
	}
	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
}
