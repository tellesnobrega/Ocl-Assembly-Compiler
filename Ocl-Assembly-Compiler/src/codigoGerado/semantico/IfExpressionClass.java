package gerador.semantico;

import gerador.parser.Classe;
import gerador.parser.GerenciadorEntidades;

public class IfExpressionClass {

	private Classe tipo;
	private String codigo;
	
	public IfExpressionClass(Object logicExp1, Object logicExp2, Object logicExp3) throws Exception{
		LogicalExpressionClass logExp1 = (LogicalExpressionClass) logicExp1;
		LogicalExpressionClass logExp2 = (LogicalExpressionClass) logicExp2;
		LogicalExpressionClass logExp3 = (LogicalExpressionClass) logicExp3;
		
		if (!logExp1.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Boolean")))
			throw new RuntimeException("ERRO");
		this.codigo = "(" + logExp2.getCodigo() + " if (" + logExp1.getCodigo() + ") else " + logExp3.getCodigo() + ")";
		this.tipo =  logExp3.getTipo();
		
	}
	
	public Classe getTipo(){
		return this.tipo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}
