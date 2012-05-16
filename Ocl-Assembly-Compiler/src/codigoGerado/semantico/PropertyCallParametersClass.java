package gerador.semantico;

import gerador.parser.Classe;

import java.util.List;

public class PropertyCallParametersClass {

	private List<Classe> parametros;

	public PropertyCallParametersClass(Object apl) {
		if (apl != null) {
			parametros = ((ActualParameterListClass) apl).getParametros();
		}
	}
	

	public List<Classe> getParametros() {
		return parametros;
	}
}
