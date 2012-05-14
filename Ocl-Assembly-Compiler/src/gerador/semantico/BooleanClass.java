package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class BooleanClass {
	
	private Classe tipo;
	private String codigo;
	
	public BooleanClass(Object m) {
		AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
		this.tipo = analisador.getGerenciador().getClasse("Boolean");
		this.codigo = (String) m;
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
