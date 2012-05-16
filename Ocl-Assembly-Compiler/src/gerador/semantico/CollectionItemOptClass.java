package gerador.semantico;

import gerador.parser.Classe;

public class CollectionItemOptClass {
	private Classe tipo;
	
	public CollectionItemOptClass(Object colItem, Object colItemOptTwo){
		CollectionItemClass collectionItem = (CollectionItemClass) colItem;
		CollectionItemOptTwoClass collectionItemOptTwo = (CollectionItemOptTwoClass) colItemOptTwo;
		if(collectionItemOptTwo == null){
			this.setTipo(collectionItem.getTipo());
		}
		else{
			this.setTipo(collectionItemOptTwo.getTipo());
		}
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
