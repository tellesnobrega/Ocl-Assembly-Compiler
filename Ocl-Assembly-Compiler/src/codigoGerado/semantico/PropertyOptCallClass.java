package gerador.semantico;

import gerador.parser.Classe;

import java.util.ArrayList;
import java.util.List;

public class PropertyOptCallClass {

	private List<Classe> parametros = new ArrayList<Classe>();

	
	public PropertyOptCallClass(Object pcp) {
		if (pcp != null) {
			parametros = ((PropertyCallParametersClass) pcp).getParametros();
		}
	}


	public List<Classe> getParametros() {
		return parametros;
	}


	public void setParametros(List<Classe> parametros) {
		this.parametros = parametros;
	}

}
