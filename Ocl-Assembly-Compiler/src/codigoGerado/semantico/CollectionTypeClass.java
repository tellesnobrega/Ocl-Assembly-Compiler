package gerador.semantico;

import gerador.parser.Classe;

public class CollectionTypeClass {
	
	private String codigo;
	private Classe tipo;
	
	public CollectionTypeClass(Object ck, Object sts) {
		CollectionKindClass colKind = (CollectionKindClass) ck;
		SimpleTypeSpecifierClass sTypeSpec = (SimpleTypeSpecifierClass) sts;
		this.codigo = colKind.getCodigo() + "(" + sTypeSpec.getPathName() + ")";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
}
