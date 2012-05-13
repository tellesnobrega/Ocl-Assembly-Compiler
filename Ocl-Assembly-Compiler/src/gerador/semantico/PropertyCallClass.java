package gerador.semantico;

import gerador.parser.Classe;

public class PropertyCallClass {

	private Classe tipo;
	private String codigo;

	public PropertyCallClass(Object pathName, Object timeExp, Object qual, Object propCallParam) {
		PathNameClass path = (PathNameClass) pathName;
		TimeExpressionClass timeExpressionClass = (TimeExpressionClass) timeExp;
		QualifierClass qualifier = (QualifierClass) qual;
		PropertyCallClass prop = (PropertyCallClass) propCallParam;
		
	}
	
	public PropertyCallClass(Object a, Object b, Object c) {
		PathNameClass path = (PathNameClass) a;
		PropertyCallParametersClass prop = (PropertyCallParametersClass) c;
		if(b instanceof TimeExpressionClass) {
			TimeExpressionClass time = (TimeExpressionClass) b;
		}else {
			QualifierClass qual = (QualifierClass) b;
		}
	}
	
	public PropertyCallClass(Object a, Object b) {
		PathNameClass path = (PathNameClass) a;
		if(b instanceof TimeExpressionClass) {
			TimeExpressionClass time = (TimeExpressionClass) b;
		}else if(b instanceof QualifierClass) {
			QualifierClass qual = (QualifierClass) b;
		}else {
			PropertyCallParametersClass prop = (PropertyCallParametersClass) b;
		}
	}
	
	public PropertyCallClass(Object a) {
		PathNameClass path = (PathNameClass) a;
	
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
