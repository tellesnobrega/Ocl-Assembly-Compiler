package gerador.semantico;

import gerador.parser.Classe;

import java.util.List;

public class ActualParameterListClass {

	private List<Classe> parametros;

	public ActualParameterListClass(Object le, Object aplo) {
		LogicalExpressionClass logicalExp = (LogicalExpressionClass) le;
		ActualParameterListOptClass parameterListOpt = (ActualParameterListOptClass) aplo;
		parametros.add(logicalExp.getTipo());
		
		if (parameterListOpt != null) {
			parametros.addAll(parameterListOpt.getParametros());
		}
	}

	public List<Classe> getParametros() {
		return parametros;
	}
}
