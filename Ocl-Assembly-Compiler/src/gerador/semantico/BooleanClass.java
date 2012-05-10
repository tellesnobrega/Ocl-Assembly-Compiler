package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Classe;

public class BooleanClass {

	private Classe tipo;
	private String codigo;
	

	public BooleanClass(Object expressao) {
		AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
		this.tipo = analisador.getGerenciador().getClasse("Boolean");
		codigo = (String) expressao;
	}
	
	public Classe getTipo(){
		return this.tipo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
}
