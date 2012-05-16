package gerador.semantico;

import gerador.parser.Classe;

public class CollectionItemOptTwoClass {

	private Classe tipo;
	
	public CollectionItemOptTwoClass(Object colItemOptTwo, Object colItem){
		CollectionItemClass collectionItem = (CollectionItemClass) colItem;
		CollectionItemOptTwoClass collectionItemOptTwo = (CollectionItemOptTwoClass) colItemOptTwo;
		if(collectionItemOptTwo == null){
			this.setTipo(collectionItem.getTipo());
		}
		else{
			this.setTipo(collectionItemOptTwo.getTipo());
		}
	}
	
	public CollectionItemOptTwoClass() {
		
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
