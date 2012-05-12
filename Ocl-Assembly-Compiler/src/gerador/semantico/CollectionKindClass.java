package gerador.semantico;

import gerador.parser.Classe;

public class CollectionKindClass {

	private Classe tipo;
	private String valor;
	private String codigo;

	public CollectionKindClass(Object colecao) {
		this.valor = (String) colecao;
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