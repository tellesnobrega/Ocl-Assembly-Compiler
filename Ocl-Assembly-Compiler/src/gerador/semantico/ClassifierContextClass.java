package gerador.semantico;

import gerador.parser.Classe;

public class ClassifierContextClass {

	private Classe tipo;
	private String codigo;

	public ClassifierContextClass(String nome, Object classifContextPackage) {
		ClassifierContextPackageClass classifContextPack = (ClassifierContextPackageClass) classifContextPackage;
	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
