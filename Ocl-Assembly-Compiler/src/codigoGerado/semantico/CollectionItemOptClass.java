package gerador.semantico;

import gerador.parser.Classe;

public class CollectionItemOptClass {
	private Classe tipo;
	private String codigo;
	
	public CollectionItemOptClass(Object colItem, Object colItemOptTwo){
		CollectionItemClass collectionItem = (CollectionItemClass) colItem;
		CollectionItemOptTwoClass collectionItemOptTwo = (CollectionItemOptTwoClass) colItemOptTwo;
		if(collectionItemOptTwo == null){
			this.setTipo(collectionItem.getTipo());
			this.setCodigo(collectionItem.getCodigo());
		}
		else{
			this.setTipo(collectionItemOptTwo.getTipo());
			this.setCodigo(collectionItem.getCodigo() + collectionItemOptTwo.getCodigo());
		}
	}

	public Classe getTipo() {
		return tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
