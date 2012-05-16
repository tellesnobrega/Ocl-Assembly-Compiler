package gerador.semantico;

import gerador.parser.Classe;

public class CollectionTypeClass {
	
	private Classe tipo;
	
	public CollectionTypeClass(Object ck, Object sts) {
		CollectionKindClass colKind = (CollectionKindClass) ck;
		SimpleTypeSpecifierClass sTypeSpec = (SimpleTypeSpecifierClass) sts;
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
}
