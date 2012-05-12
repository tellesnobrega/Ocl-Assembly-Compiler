package gerador.semantico;

import gerador.parser.Classe;
import gerador.parser.Pacote;

public class PathNameClass {

	private Boolean navegacaoEntrePacotes = false;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
	private Classe tipo;
	private String codigo;

	public PathNameClass(String n, Object doubleColon, Object pn) {
		this.navegacaoEntrePacotes = true;
		PathNameClass pathName = (PathNameClass) pn;
		Pacote pacote = analisador.getGerenciador().getPacotes().getPacote(n);
		if (pacote == null) {
			throw new RuntimeException("Erro semantico: pacote " + n
					+ " nao existe!");
		}
		if (!pacote.temClasse(pathName.getCodigo())) {
			throw new RuntimeException("Erro semantico: a classe "
					+ pathName.getCodigo() + " nao existe no pacote "
					+ n);
		}
		this.codigo = ((PathNameClass) pn).getCodigo();
	}

	public String getCodigo() {
		return codigo;
	}
	
	public Classe getTipo() {
		return tipo;
	}

	public Boolean getNavegacaoEntrePacotes() {
		return navegacaoEntrePacotes;
	}
}
