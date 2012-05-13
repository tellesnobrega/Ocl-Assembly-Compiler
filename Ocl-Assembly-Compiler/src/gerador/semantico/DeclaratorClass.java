package gerador.semantico;

import gerador.parser.Classe;

public class DeclaratorClass {

	private Classe tipo;
	private String codigo;

	public DeclaratorClass(Object n1, Object nameOpt, Object sTypeSpecOpt, Object n2, Object ts, Object exp) {
		String name = (String) n1;
		NameOpt nOpt = (NameOpt) nameOpt;
		SimpleTypeSpecifierOptClass simpleTypeSpecOpt = (SimpleTypeSpecifierOptClass) sTypeSpecOpt;
		String name2 = (String) n2;
		TypeSpecifierClass typeSpec = (TypeSpecifierClass) ts;
		ExpressionClass expression = (ExpressionClass) exp;
	}
	
	public DeclaratorClass(Object n, Object nameOpt, Object sTypeSpecOpt) {
		String name = (String) n;
		NameOpt nOpt = (NameOpt) nameOpt;
		SimpleTypeSpecifierOptClass simpleTypeSpecOpt = (SimpleTypeSpecifierOptClass) sTypeSpecOpt;
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
