package gerador.semantico;

import gerador.parser.Classe;

public class SimpleTypeSpecifierClass {

	private Classe tipo;
	private PathNameClass pathName;
	
	public SimpleTypeSpecifierClass(PathNameClass pathName) {
		this.setPathName(pathName);
	}

	public Classe getTipo() {
		return tipo;
	}

	public PathNameClass getPathName() {
		return pathName;
	}

	public void setPathName(PathNameClass pathName) {
		this.pathName = pathName;
	}
}
