package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class RelationalExpressionClass {

	private Classe tipo;
	private String codigo;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();

	public RelationalExpressionClass(int linha, int coluna, Object addExp) {
		AdditiveExpressionClass add1 = (AdditiveExpressionClass) addExp;
		this.tipo = add1.getTipo();
		this.codigo = add1.getCodigo();
	}

	public RelationalExpressionClass(int linha, int coluna, Object addExp, Object relOp, Object addExp2) {
		AdditiveExpressionClass add1 = (AdditiveExpressionClass) addExp;
		RelationalOperatorClass relOpe = (RelationalOperatorClass) relOp;
		AdditiveExpressionClass add2 = (AdditiveExpressionClass) addExp2;
		
		if (!add1.getTipo().isTypeOf(add2.getTipo())) {
			throw new RuntimeException("Nao pode comparar o tipo " + add1.getTipo() + " com o tipo " + add2.getTipo() + AnalisadorSemantico.identificaErro(linha, coluna));
		} else {
			this.tipo = analisador.getGerenciador().getClasse("Boolean");
			this.codigo = add1.getCodigo() + " " + relOpe.getOperador() + " " + add2.getCodigo();
		}
	}
	

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
