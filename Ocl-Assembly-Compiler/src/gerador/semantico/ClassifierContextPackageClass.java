package gerador.semantico;

import gerador.parser.Classe;

public class ClassifierContextPackageClass {
	
	private Classe tipo;
	private Classe codigo;
	
	public ClassifierContextPackageClass(String nome, Object obj) {
		
	}

	public Classe getCodigo() {
		return codigo;
	}

	public void setCodigo(Classe codigo) {
		this.codigo = codigo;
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

}
