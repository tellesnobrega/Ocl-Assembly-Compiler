package gerador.semantico;

import gerador.parser.Classe;

import java.util.ArrayList;
import java.util.List;

public class PropertyCallParametersClass {

	private List<Classe> parametros = new ArrayList<Classe>();
	private String codigo;

	public PropertyCallParametersClass(Object apl) {
		if (apl != null) {
			parametros = ((ActualParameterListClass) apl).getParametros();
			this.codigo = ((ActualParameterListClass) apl).getCodigo();
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public List<Classe> getParametros() {
		return parametros;
	}
}
