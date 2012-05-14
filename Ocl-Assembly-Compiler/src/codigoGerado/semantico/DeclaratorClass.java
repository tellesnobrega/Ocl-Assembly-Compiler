package gerador.semantico;

import gerador.parser.Classe;

public class DeclaratorClass {

	private Classe tipo;
	private String codigo;

	public DeclaratorClass(Object n1, Object nameOpt, Object sTypeSpecOpt, Object n2, Object ts, Object exp) {
		String name = (String) n1;
		NameOptClass nOpt = (NameOptClass) nameOpt;
		SimpleTypeSpecifierOptClass simpleTypeSpecOpt = (SimpleTypeSpecifierOptClass) sTypeSpecOpt;
		String name2 = (String) n2;
		TypeSpecifierClass typeSpec = (TypeSpecifierClass) ts;
		ExpressionClass expression = (ExpressionClass) exp;
		this.codigo = name + nOpt.getCodigo() + simpleTypeSpecOpt.getOperador() + 
				name2 + ":" + typeSpec.getCodigo() + "=" + expression.getCodigo() + "|";
	}
	
	public DeclaratorClass(Object n, Object nameOpt, Object sTypeSpecOpt) {
		String name = (String) n;
		NameOptClass nOpt = (NameOptClass) nameOpt;
		SimpleTypeSpecifierOptClass simpleTypeSpecOpt = (SimpleTypeSpecifierOptClass) sTypeSpecOpt;
		this.codigo = name + nOpt.getCodigo() + simpleTypeSpecOpt.getOperador() + "|";
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
