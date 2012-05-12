package gerador.semantico;

import gerador.parser.Classe;
import gerador.parser.Constantes;

public class UnaryExpressionClass {

	private Classe tipo;
	private String codigo;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();

	
	public UnaryExpressionClass(int linha, int coluna, Object unaryOper, Object postFixExp){
		UnaryOperatorClass unaryOp = (UnaryOperatorClass) unaryOper;
		PostfixExpressionClass postFixEx = (PostfixExpressionClass) postFixExp;
		
		if (unaryOp.getOperador().equals(Constantes.OP_UNARY_MENOS)) {
			this.tipo = analisador.getGerenciador().getClasse("Number");
			if (! postFixEx.getTipo().isTypeOf(analisador.getGerenciador().getClasse("Number")))
				throw new RuntimeException("O operador \"-\" nao aceita o tipo " + postFixEx.getTipo() + AnalisadorSemantico.identificaErro(linha, coluna));
		} else if (unaryOp.getOperador().equals(Constantes.OP_UNARY_NOT)) {
			this.tipo = analisador.getGerenciador().getClasse("Boolean");
			if (!postFixEx.getTipo().isTypeOf(analisador.getGerenciador().getClasse("Boolean")))
				throw new RuntimeException("O operador \"not\" nao aceita o tipo " + postFixEx.getTipo() + AnalisadorSemantico.identificaErro(linha, coluna));
		}
		
		this.codigo = unaryOp.getOperador() + " " + postFixEx.getCodigo();
	}
	
	public UnaryExpressionClass(Object postFixExp) {
		PostfixExpressionClass postFixEx = (PostfixExpressionClass) postFixExp;
		
		this.tipo = postFixEx.getTipo();
		this.codigo = postFixEx.getCodigo();
	}
	
	
	public String getCodigo(){
		return this.codigo;
	}

	public Classe getTipo() {
		return tipo;
	}

}