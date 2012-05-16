package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class AdditiveExpressionOptClass {
	
	private Classe tipo;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
	
	
	public AdditiveExpressionOptClass(int linha, int coluna, Object addOpt, Object addOp, Object multiExp){
		MultiplicativeExpressionClass multi = (MultiplicativeExpressionClass) multiExp;
		AdditiveExpressionOptClass optAdd = (AdditiveExpressionOptClass) addOpt;
		AddOperatorClass addOperator = (AddOperatorClass) addOp;
		
		Classe number = analisador.getGerenciador().getClasse("Number");
		
		if (!multi.getTipo().isTypeOf(number) || (optAdd != null && !optAdd
				.getTipo().isTypeOf(number))) {
			throw new RuntimeException("tipos nao permitidos para a operacao " + addOperator.getOperador() + analisador.identificaErro(linha, coluna));
		}
		this.tipo = number;
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}
}
