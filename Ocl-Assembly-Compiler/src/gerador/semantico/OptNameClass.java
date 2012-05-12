package gerador.semantico;

import gerador.parser.Classe;

public class OptNameClass {
	
	private Classe tipo;
	private String codigo;
	
	public OptNameClass(Object p) {
		AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
		tipo = analisador.getGerenciador().getClasse("String");
		codigo = (String)p;
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
