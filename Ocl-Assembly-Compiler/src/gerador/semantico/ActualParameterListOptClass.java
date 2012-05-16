package gerador.semantico;

import gerador.parser.Classe;

import java.util.List;

public class ActualParameterListOptClass {

	private List<Classe> parametros;
	private String codigo;

	public ActualParameterListOptClass(Object exp, Object aplo) {
		ExpressionClass expression = (ExpressionClass) exp;
		ActualParameterListOptClass parameterListOpt = (ActualParameterListOptClass) aplo;
		parametros.add(expression.getTipo());
		
		if (parameterListOpt != null) {
			parametros.addAll(parameterListOpt.getParametros());
		} else {
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public List<Classe> getParametros() {
		return parametros;
	}
}
