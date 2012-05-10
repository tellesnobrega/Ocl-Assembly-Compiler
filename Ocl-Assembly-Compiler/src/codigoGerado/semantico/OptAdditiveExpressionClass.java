package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class OptAdditiveExpressionClass {

	private Classe tipo;
	private String codigo;
	
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();

	public OptAdditiveExpressionClass(int linha, int coluna, Object ao, Object me, Object ope) {
		MultiplicativeExpressionClass m = (MultiplicativeExpressionClass) me;
		OptAdditiveExpressionClass op = (OptAdditiveExpressionClass) ope;
		AddOperatorClass operador = (AddOperatorClass) ao;
		Classe number = analisador.getGerenciador().getClasse("Number");

		if (!m.getTipo().isTypeOf(number) || (op != null && !op
				.getTipo().isTypeOf(number))) {
			throw new RuntimeException("tipos nao permitidos para a operacao " + operador.getOperador() + analisador.identificaErro(linha, coluna));
		}
		this.setTipo(number);
		
		if (ope == null) {
			this.setCodigo(operador.getOperador() + m.getCodigo());
		} else {
			this.setCodigo(operador.getOperador() + m.getCodigo() + op.getCodigo());
		}
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}