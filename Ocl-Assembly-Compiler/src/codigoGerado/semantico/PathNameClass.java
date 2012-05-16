package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Pacote;

public class PathNameClass {

	private Boolean navegacaoEntrePacotes = false;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();
	
	private String codigo;
	private String value = "";
	

	public PathNameClass(int linha, int coluna, String n) {
		this.value = n;
		this.codigo = n;
	}

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
		this.codigo= ((PathNameClass) pn).getCodigo();
	}

	public String getCodigo() {
		return codigo;
	}
	
	public Boolean getNavegacaoEntrePacotes() {
		return navegacaoEntrePacotes;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
