package gerador.semantico;

import gerador.parser.Classe;

public class LiteralClass {

	private Classe tipo;
	private String codigo;

	public LiteralClass(Object literal) throws Exception {
		if (literal instanceof BooleanClass) {
			this.tipo = ((BooleanClass) literal).getTipo();
			this.codigo = ((BooleanClass) literal).getCodigo();
		} else if (literal instanceof NumberClass) {
			this.tipo = ((NumberClass) literal).getTipo();
			this.codigo = ((NumberClass) literal).getCodigo();
		} else {
			throw new Exception("Erro!");
		}
	}
	
	public LiteralClass(Object literal, Object tipo) {
		AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
		this.tipo = analisador.getGerenciador().getClasse(((String) tipo));
		this.codigo = (String) literal;
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
