package gerador.semantico;

import gerador.parser.Classe;

import java.util.List;

public class PropertyCallParametersClass {

	private List<Classe> parametros;
	private String codigo;

	public PropertyCallParametersClass(Object apl) {
		if (apl != null) {
			parametros = ((ActualParameterListClass) apl).getParametros();
			this.codigo = ((ActualParameterListClass) apl).getCodigo();
		}
	}
	
	public PropertyCallParametersClass() {
		this.codigo = "()";
	}

	public String getCodigo() {
		return codigo;
	}

	public List<Classe> getParametros() {
		return parametros;
	}
}