package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class NumberClass {

	private Classe tipo;
	private String codigo;
	
	public String getCodigo() {
		return codigo;
	}
	
	public NumberClass(Object ob, String type) {
		AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
		this.tipo = analisador.getGerenciador().getClasse(type);
		this.codigo = (String) ob;
	}
	
	public Classe getTipo() {
		return tipo;
	}
}
