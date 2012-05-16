package gerador.semantico;

import gerador.parser.Classe;

public class TypeSpecifierClass {
	
	private Classe tipo;
	
	public TypeSpecifierClass(int linha, int coluna, Object obj) throws Exception {
		
		if(obj instanceof SimpleTypeSpecifierClass) {
			SimpleTypeSpecifierClass simpleTypeSpec = (SimpleTypeSpecifierClass) obj;
			this.tipo = simpleTypeSpec.getTipo();
		}else if(obj instanceof CollectionTypeClass) {
			CollectionTypeClass colType = (CollectionTypeClass) obj;
			this.tipo = colType.getTipo();
		}else {
			throw new Exception("Tipo nao suportado para essa classe, na linha: " + linha + " e coluna: " + coluna);
		}
		
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
}
