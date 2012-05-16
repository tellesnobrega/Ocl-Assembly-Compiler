package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;
import gerador.parser.GerenciadorEntidades;

public class MultiplicativeExpressionClass{

	private Classe tipo;
	
	public MultiplicativeExpressionClass(int linha, int coluna, Object unaryExp, Object multExpOpt ){
		UnaryExpressionClass unary = (UnaryExpressionClass) unaryExp;
		MultiplicativeExpressionOptClass mult = (MultiplicativeExpressionOptClass) multExpOpt;
		
		if (mult == null || unary.getTipo().isTypeOf(mult.getTipo()) || unary.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Integer")) && mult.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Integer"))) {
			this.tipo = unary.getTipo();
		} else if (!(unary.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Double")) || unary.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Integer"))) ||
				!(mult.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Double")) || mult.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Integer")))) {
			throw new RuntimeException("Ocorreu um erro: " + AnalisadorSemantico.identificaErro(linha, coluna));
		} else if (unary.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Double")) || mult.getTipo().isTypeOf(GerenciadorEntidades.getInstance().getClasse("Double"))) {
			this.tipo = GerenciadorEntidades.getInstance().getClasse("Double");
		} else {
			throw new RuntimeException("Ocorreu eu erro: " + AnalisadorSemantico.identificaErro(linha, coluna));
		}
		
		
	}
	
	public Classe getTipo(){
		return this.tipo;
	}
	
}