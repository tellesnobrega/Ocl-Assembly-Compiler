package gerador.semantico;

import gerador.parser.Classe;

public class LiteralCollectionClass {

	private Classe tipo;
	private String codigo;

	public LiteralCollectionClass(Object collectionKind, Object collectionItemOpt) {
		CollectionKindClass colKind = (CollectionKindClass) collectionKind;
		CollectionItemOptClass colItemOpt = (CollectionItemOptClass) collectionItemOpt;
		this.codigo = colKind.getCodigo() + "{" + colItemOpt.getCodigo() + "}";
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
