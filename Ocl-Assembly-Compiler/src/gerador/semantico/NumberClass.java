package gerador.semantico;

import gerador.parser.Classe;

public class NumberClass {

	private Classe tipo;
	private String codigo;

	public NumberClass(Object objeto, String tipo) {
		AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
		this.tipo = analisador.getGerenciador().getClasse(tipo);
		this.codigo = (String) objeto;
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
