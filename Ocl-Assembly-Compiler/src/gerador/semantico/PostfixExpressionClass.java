package gerador.semantico;

import gerador.parser.Classe;

public class PostfixExpressionClass {

	private Classe tipo;
	private String codigo;
	AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
	private String variavel = analisador.getVariavel();

	
	public PostfixExpressionClass(Object mspe) {
		ManySelfPostfixExpressionClass msp = (ManySelfPostfixExpressionClass) mspe;
		this.tipo = msp.getTipo();
		this.codigo = analisador.isFluxoComum() ? variavel + msp.getCodigo() : msp.getCodigo();
	}
	
	public PostfixExpressionClass(int linha, int coluna, Object pe, Object mpe) {
		ManyPostfixExpressionClass m = (ManyPostfixExpressionClass) mpe;
		PrimaryExpressionClass p = (PrimaryExpressionClass) pe;
		if (m == null) {
			this.tipo = p.getTipo();
		} else {
			this.tipo = m.getTipo();
		}
		if (verificaLiteral(p)) {
			if (analisador.isFluxoComum())
				this.codigo = (mpe == null) ? p.getCodigo(): (p.getCodigo() + m.getCodigo());
			else
				this.codigo = (mpe == null) ? p.getCodigo(): m.getCodigo();
		} else {
			if (analisador.isFluxoComum())
				this.codigo = variavel + "." + ((mpe == null) ? p.getCodigo(): (p.getCodigo() + m.getCodigo()));
			else
				this.codigo = (mpe == null) ? (variavel + "." + p.getCodigo()): m.getCodigo();
		}
	}

	private boolean verificaLiteral(PrimaryExpressionClass p) {
		String primaryExp = (p.getCodigo()).split("\\.")[0].split("\\(")[0];
		return !(analisador.getContexto().temAtributo(primaryExp) 
				|| analisador.getContexto().temMetodo(primaryExp));
	}


	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
