package gerador.semantico;

import gerador.parser.Classe;

public class LiteralCollectionClass {

	private Classe tipo;

	public LiteralCollectionClass(Object collectionKind, Object collectionItemOpt) {
		CollectionKindClass colKind = (CollectionKindClass) collectionKind;
		CollectionItemOptClass colItemOpt = (CollectionItemOptClass) collectionItemOpt;
	}


	public Classe getTipo() {
		return tipo;
	}
}
