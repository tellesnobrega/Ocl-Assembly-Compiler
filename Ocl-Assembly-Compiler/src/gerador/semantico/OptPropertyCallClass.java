package gerador.semantico;

import gerador.parser.Classe;

import java.util.List;

public class OptPropertyCallClass {

	private List<Classe> parametros;
	private String codigo;

	public OptPropertyCallClass(Object pcp) {
		if (pcp != null) {
			parametros = ((PropertyCallParametersClass) pcp).getParametros();
			this.codigo = ((PropertyCallParametersClass) pcp).getCodigo();
		}
	}


	public String getCodigo() {
		return codigo;
	}

	public List<Classe> getParametros() {
		return parametros;
	}
}
