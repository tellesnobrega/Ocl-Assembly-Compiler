package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;
import gerador.parser.Constantes;
import gerador.parser.GerenciadorEntidades;

public class MultiplicativeExpressionOptClass {

	private Classe tipo;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
	
	public MultiplicativeExpressionOptClass(Object multExpOpt, Object multOp, Object uExp) {
		MultiplicativeExpressionOptClass multExp = (MultiplicativeExpressionOptClass) multExpOpt;
		MultiplyOperatorClass mo = (MultiplyOperatorClass) multOp;
		UnaryExpressionClass unary = (UnaryExpressionClass) uExp;
		
		if (!(unary.getTipo().isTypeOf(
				analisador.getGerenciador().getClasse("Number")))) {
			throw new RuntimeException(
			"Tipo nao permitido!");
		}
		if (multExp != null) {
			if (!(multExp.getTipo().isTypeOf(
					analisador.getGerenciador().getClasse("Number")))) {
				throw new RuntimeException(
				"Tipo nao permitido!");
			}
		}
		
		if (mo.getOperador().equals(Constantes.OP_DIV)) {
			this.tipo = GerenciadorEntidades.getInstance().getClasse("Double");
		} else {
			if (multExp == null) {
				this.tipo = unary.getTipo();
			} else {
				if (multExp.getTipo().isTypeOf(analisador.getGerenciador().getClasse("Double")) || unary.getTipo().isTypeOf(analisador.getGerenciador().getClasse("Double")))
					this.tipo = GerenciadorEntidades.getInstance().getClasse("Double");
				else
					this.tipo = GerenciadorEntidades.getInstance().getClasse("Integer");
			}
		}
	}
	
	public Classe getTipo() {
		return tipo;
	}
	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
	
}
