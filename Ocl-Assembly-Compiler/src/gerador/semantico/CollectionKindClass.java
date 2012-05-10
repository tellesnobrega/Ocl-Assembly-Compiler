package gerador.semantico;

import gerador.parser.Classe;

public class CollectionKindClass {

	private Classe tipo;
	private String valor;
	private String codigo;

	public CollectionKindClass(Object collecao) {
		this.valor = (String) collecao;
	}
	
	public String getValor() {
		return this.valor;
	}

	public Classe getTipo(){
		return tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}
}