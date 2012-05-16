package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class CollectionKindClass {

	private Classe tipo;
	private String valor;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
	
	public CollectionKindClass(Object colecao) {
		this.valor = (String) colecao;
	}
	
	public String getValor() {
		return this.valor;
	}

	public Classe getTipo(){
		return tipo;
	}
	
}