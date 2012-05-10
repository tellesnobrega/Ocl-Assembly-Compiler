package gerador;

import gerador.parser.Classe;
import gerador.parser.Colecao;
import gerador.parser.GerenciadorEntidades;
import gerador.semantico.PrimaryExpressionClass;
import gerador.semantico.PropertyCallClass;
import gerador.semantico.PropertyCallColClass;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AnalisadorSemantico {

	private static AnalisadorSemantico instance;
	private GerenciadorEntidades gerenciador = GerenciadorEntidades
			.getInstance();

	private Stack<Classe> contextos = new Stack<Classe>();
	private Stack<String> variaveis = new Stack<String>();
	private Stack<String> fluxos = new Stack<String>();
	private Stack<Boolean> isFluxos = new Stack<Boolean>();
	private Map<String, Classe> metodosColecao = new HashMap<String, Classe>();
	private String logicalOperator;
	private String alias;
	private int contador = 1;
	private boolean fluxoComum = true;
	public String fluxoAlternativo;
	private String fluxo;
	public String ultimaOperacaoSobreColecao;
	
	public static FileWriter writer;
	public static PrintWriter saida;

	private AnalisadorSemantico() {
		populaMetodosColecao();
	}
	
	private void populaMetodosColecao() {
		metodosColecao.put("size", gerenciador.getClasse("Number"));
		metodosColecao.put("exists", gerenciador.getClasse("Boolean"));
		metodosColecao.put("notEmpty", gerenciador.getClasse("Boolean"));
		metodosColecao.put("forAll", gerenciador.getClasse("Boolean"));
		metodosColecao.put("select", gerenciador.getClasse(""));
		metodosColecao.put("isEmpty", gerenciador.getClasse("Boolean"));
		metodosColecao.put("isUnique", gerenciador.getClasse("Boolean"));
		metodosColecao.put("includes", gerenciador.getClasse("Boolean"));
		metodosColecao.put("includesAll", gerenciador.getClasse("Boolean"));
		metodosColecao.put("first", gerenciador.getClasse(""));
		metodosColecao.put("last", gerenciador.getClasse(""));
		metodosColecao.put("excludes", gerenciador.getClasse("Boolean"));
		metodosColecao.put("excludesAll", gerenciador.getClasse("Boolean"));
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public Stack<Classe> getContextos() {
		return this.contextos;
	}

	public static AnalisadorSemantico getInstance() {
		if (instance == null)
			instance = new AnalisadorSemantico();
		return instance;
	}
	
	public void setVariavel() {
		if (variaveis.isEmpty()) {
			variaveis.add("i1");
		} else {
			variaveis.add("i" + (Integer.parseInt(variaveis.peek().split("i")[1]) + 1));
		}
	}

	public String getVariavel() {
		return variaveis.peek();
	}

	public void retrocedeVariavel() {
		variaveis.pop();
	}

	public void setContexto() {
		Classe contexto = AnalisadorSemantico.getInstance().getContextos().get(0);
		if (contexto == null) {
			throw new RuntimeException("Erro no contexto");
		}
		contextos.add(contexto);
	}
	
	public void setContexto(int linha, int coluna, String nome) {
		Classe contexto = gerenciador.getClasse(nome);
		if (contexto == null) {
			throw new RuntimeException("O contexto " + nome
					+ AnalisadorSemantico.identificaErro(linha, coluna)
					+ "nao existe.");
		}
		contextos.add(contexto);
	}
	
	public void setContexto(int linha, int coluna, Object o) {
		Classe contexto;
		if (o instanceof PropertyCallClass) {
			Classe classe = ((PropertyCallClass) o).getTipo();
			if (classe.ehColecao()) {
				contexto = (Colecao) classe;
			} else {
				contexto = gerenciador.getClasse(classe.getNome());
			}
		} else if (o instanceof PropertyCallColClass) {
			Classe classe = ((PropertyCallColClass) o).getTipo();
			if (classe.ehColecao()) {
				contexto = (Colecao) classe;
			} else {
				contexto = gerenciador.getClasse(classe.getNome());
			}
		} else {
			Classe classe = ((PrimaryExpressionClass) o).getTipo();
			if (classe.ehColecao()) {
				contexto = (Colecao) classe;
			} else {
				contexto = gerenciador.getClasse(classe.getNome());
			}

		}
		if (contexto == null) {
			throw new RuntimeException("O contexto "
					+ AnalisadorSemantico.identificaErro(linha, coluna)
					+ "nao existe.");
		}
		
		contextos.add(contexto);
	}

	public void retrocedeContexto() {
		if (!contextos.isEmpty())
			contextos.pop();
	}

	public Classe getContexto() {
		return contextos.peek();
	}

	public GerenciadorEntidades getGerenciador() {
		return gerenciador;
	}

	public static String identificaErro(int linha, int coluna) {
		return " (linha: " + (linha + 1) + ", coluna " + (coluna + 1) + ") ";
	}
	
	public boolean temMetodoColecao(String nome) {
		return metodosColecao.keySet().contains(nome);
	}

	public Map<String, Classe> getMetodosColecao() {
		return metodosColecao;
	}

	public void setMetodosColecao(Map<String, Classe> metodosColecao) {
		this.metodosColecao = metodosColecao;
	}

	public void setLogicalOperator(String operador) {
		this.logicalOperator = operador;		
	}

	public String getLogicalOperator() {
		return logicalOperator;
	}

	public boolean isFluxoComum() {
		return this.isFluxos .peek();
	}

	public void empilhaFluxoComum(boolean fluxoComum) {
		this.isFluxos.push(fluxoComum);
	}

	public void desempilhaFluxoComum() {
		if (isFluxos.isEmpty())
			this.isFluxos.pop();
	}

	public void setFluxoAlternativo(String fluxoAlternativo) {
		if (this.fluxoAlternativo == null)
			this.fluxoAlternativo = fluxoAlternativo;
		
	}

	public String getFluxoAlternativo() {
		return fluxoAlternativo;
	}

	public void iniciaFluxoAlternativo() {
		this.fluxo = "";
	}

	public void empilhaFluxo() {
		this.fluxos.push(this.fluxo);
	}

	public void desempilhaFluxo() {
		if (!fluxos.isEmpty())
			this.fluxos.pop();
	}

	public String getFluxoAtual() {
		return this.fluxos.peek();
	}

	public Stack<String> getFluxos() {
		return fluxos;
	}

	public void setFluxos(Stack<String> fluxos) {
		this.fluxos = fluxos;
	}

	public String getFluxo() {
		return fluxo;
	}

	public void setFluxo(String fluxo) {
		this.fluxo += fluxo;
	}

}