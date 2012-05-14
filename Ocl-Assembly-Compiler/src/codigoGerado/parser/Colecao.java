package gerador.parser;

import org.jdom.Element;

public class Colecao extends Classe {
	private Classe tipoObjetos;
	private String tipoObjetosStr;
	private ColecaoKind tipoColecao;

	public Colecao(Classe tipoObjetos) {
		this(tipoObjetos, ColecaoKind.COLLECTION);
	}

	public Colecao(Classe tipoObjetos, ColecaoKind tipoColecao) {
		super(tipoObjetos.getNome());
		this.setTipoColecao(tipoColecao);
		this.setNome(formatNome(tipoObjetos.getNome()));
		this.setTipoObjetos(tipoObjetos);
	}

	public Colecao(Element elemento, String tipoObjetosStr)
			throws Exception {
		super(elemento);
		this.setTipoColecao(ColecaoKind.COLLECTION);
		this.setNome(formatNome(tipoObjetosStr));
		this.setTipoObjetosStr(tipoObjetosStr);
	}

	public boolean ehColecao() {
		return true;
	}

	public Atributo getAtributo(String atributo) {
		return tipoObjetos.getAtributo(atributo);
	}

	public Metodo getMetodo(String nome) {
		Classe bool = GerenciadorEntidades.getInstance().getClasse("Boolean");
		Classe integer = GerenciadorEntidades.getInstance()
				.getClasse("Integer");

		if (nome.equals(Constantes.OP_COL_ANY)) {
			return new Metodo(nome, tipoObjetos, bool);
		} else if (nome.equals(Constantes.OP_COL_AT)) {
			return new Metodo(nome, tipoObjetos, integer);
		} else if (nome.equals(Constantes.OP_COL_SELECT)) {
			return new Metodo(nome, new Colecao(tipoObjetos), bool);
		} else if (nome.equals(Constantes.OP_COL_REJECT)) {
			return new Metodo(nome, new Colecao(tipoObjetos), bool);
		} else if (nome.equals(Constantes.OP_COL_IS_EMPTY)) {
			return new Metodo(nome, bool);
		} else if (nome.equals(Constantes.OP_COL_NOT_EMPTY)) {
			return new Metodo(nome, bool);
		} else if (nome.equals(Constantes.OP_COL_SIZE)) {
			return new Metodo(nome, integer);
		} else if (nome.equals(Constantes.OP_COL_INCLUDES)) {
			return new Metodo(nome, bool, tipoObjetos);
		} else if (nome.equals(Constantes.OP_COL_EXCLUDES)) {
			return new Metodo(nome, bool, tipoObjetos);
		} else if (nome.equals(Constantes.OP_COL_INCLUDES_ALL)) {
			return new Metodo(nome, bool, new Colecao(tipoObjetos));
		} else if (nome.equals(Constantes.OP_COL_EXCLUDES_ALL)) {
			return new Metodo(nome, bool, new Colecao(tipoObjetos));
		} else if (nome.equals(Constantes.OP_COL_INCLUDING)) {
			return new Metodo(nome, new Colecao(tipoObjetos), tipoObjetos);
		} else if (nome.equals(Constantes.OP_COL_EXCLUDING)) {
			return new Metodo(nome, new Colecao(tipoObjetos), tipoObjetos);
		} else if (nome.equals(Constantes.OP_COL_SUM)) {
			return new Metodo(nome, integer);
		} else if (nome.equals(Constantes.OP_COL_IS_UNIQUE)) {
			return new Metodo(nome, bool, bool);
		} else if (nome.equals(Constantes.OP_COL_COUNT)) {
			return new Metodo(nome, integer, bool);
		} else if (nome.equals(Constantes.OP_COL_EXISTS)) {
			return new Metodo(nome, bool, bool);
		} else if (nome.equals(Constantes.OP_COL_FOR_ALL)) {
			return new Metodo(nome, bool, bool);
		} else if (nome.equals(Constantes.OP_COL_UNION)) {
			return new Metodo(nome, new Colecao(tipoObjetos), new Colecao(
					tipoObjetos));
		} else if (nome.equals(Constantes.OP_COL_INTERSECTION)) {
			return new Metodo(nome, new Colecao(tipoObjetos), new Colecao(
					tipoObjetos));
		}
		return null;
	}

	public void setTipoObjetos(Classe tipoObjetos) {
		this.tipoObjetos = tipoObjetos;
	}

	public Classe getTipoObjetos() {
		return tipoObjetos;
	}

	public Classe getTipoRetornoMetodo(String nomeOp) {
		return metodos.get(nomeOp).getTipoRetorno();
	}

	public void setTipoObjetosStr(String tipoObjetosStr) {
		this.tipoObjetosStr = tipoObjetosStr;
	}

	public String getTipoObjetosStr() {
		return tipoObjetosStr;
	}

	public void setTipoColecao(ColecaoKind tipoColecao) {
		this.tipoColecao = tipoColecao;
	}

	public ColecaoKind getTipoColecao() {
		return tipoColecao == null ? ColecaoKind.COLLECTION : tipoColecao;
	}

	private String formatNome(String tipoObjetos) {
		return getTipoColecao().getNome() + "<" + tipoObjetos + ">";
	}
	
	public enum ColecaoKind {
	    BAG("Bag"), COLLECTION("Collection"), SET("Set"), ORDERED_SET("OrderedSet"), SEQUENCE("Sequence");

	    private String nome;

	    ColecaoKind(String nome) {
	            this.nome = nome;
	    }

	    public String getNome() {
	            return nome;
	    }
	}
}
