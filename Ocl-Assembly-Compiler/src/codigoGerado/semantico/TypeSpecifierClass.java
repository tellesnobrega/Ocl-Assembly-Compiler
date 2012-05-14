package gerador.semantico;

import gerador.parser.Classe;

public class TypeSpecifierClass {
	
	private Classe tipo;
	private String codigo;
	
	public TypeSpecifierClass(Object obj) {
		
		if(obj instanceof SimpleTypeSpecifierClass) {
			SimpleTypeSpecifierClass simpleTypeSpec = (SimpleTypeSpecifierClass) obj;
		}else {
			CollectionTypeClass colType = (CollectionTypeClass) obj;
		}
		
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
