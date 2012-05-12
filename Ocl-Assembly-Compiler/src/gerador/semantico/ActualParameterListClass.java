package gerador.semantico;

import gerador.parser.Classe;

import java.util.List;


public class ActualParameterListClass {

	private List<Classe> parametros;
	private String codigo;

	public ActualParameterListClass(Object expression, Object actualParameterListOpt) {
		ExpressionClass l = (ExpressionClass) expression;
		ActualParameterListOptClass m = (ActualParameterListOptClass) actualParameterListOpt;
		parametros.add(l.getTipo());
		
		if (m != null) {
			parametros.addAll(m.getParametros());
			this.codigo =  l.getCodigo()+ ", " + m.getCodigo();
		} else {
			this.codigo = l.getCodigo() + ")";
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public List<Classe> getParametros() {
		return parametros;
	}
}
