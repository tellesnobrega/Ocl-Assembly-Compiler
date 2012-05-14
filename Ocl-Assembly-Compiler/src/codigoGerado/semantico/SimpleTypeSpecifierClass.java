package gerador.semantico;

import gerador.parser.Classe;

public class SimpleTypeSpecifierClass {

	private Classe tipo;
	private PathNameClass pathName;
	
	public SimpleTypeSpecifierClass(Object pathName) {
		PathNameClass path = (PathNameClass)pathName;
		this.setPathName(path);
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
