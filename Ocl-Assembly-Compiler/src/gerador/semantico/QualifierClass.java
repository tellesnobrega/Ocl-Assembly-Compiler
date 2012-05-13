package gerador.semantico;

import gerador.parser.Classe;

public class QualifierClass {
	
	private String codigo;
	private Classe tipo;
	
	public QualifierClass(Object exp, Object apl) {
		ExpressionClass expression = (ExpressionClass) exp;
		ActualParameterListClass actualParamList = (ActualParameterListClass) apl;
		
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
