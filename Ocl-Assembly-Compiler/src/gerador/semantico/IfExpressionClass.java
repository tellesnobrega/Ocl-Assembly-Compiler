package gerador.semantico;

import gerador.parser.Classe;
import gerador.parser.GerenciadorEntidades;

public class IfExpressionClass {

	private Classe tipo;
	
	public IfExpressionClass(Object logicExp1, Object logicExp2, Object logicExp3) throws Exception{
		LogicalExpressionClass logExp1 = (LogicalExpressionClass) logicExp1;
		LogicalExpressionClass logExp2 = (LogicalExpressionClass) logicExp2;
		LogicalExpressionClass logExp3 = (LogicalExpressionClass) logicExp3;
		
		if (!logExp1.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Boolean")))
			throw new RuntimeException("ERRO");
		this.tipo =  logExp3.getTipo();
		
	}
	
	public Classe getTipo(){
		return this.tipo;
	}
	
}
