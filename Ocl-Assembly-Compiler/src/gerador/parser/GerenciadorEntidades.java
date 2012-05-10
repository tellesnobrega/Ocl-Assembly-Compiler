package gerador.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class GerenciadorEntidades {
	private static GerenciadorEntidades instance;

	private List<Classe> tiposPrimitivos;
	private GerenciadorPacotes pacotes;

	private GerenciadorEntidades() {
		tiposPrimitivos = new ArrayList<Classe>();
		pacotes = new GerenciadorPacotes();
	}

	public static GerenciadorEntidades getInstance() {
		if (instance == null)
			instance = new GerenciadorEntidades();
		return instance;
	}

	public void addClasse(String nomeClasse) throws Exception {
		pacotes.getPacotePadrao().addClasse(new Classe(nomeClasse));
	}

	public Classe getClasse(String nomeClasse) {
		Pacote pacote = pacotes.getPacotePadrao();
		if (pacote == null)
			return null;
		return pacote.getClasse(nomeClasse);
	}

	public Classe getClasse(String nomePacote, String nomeClasse) {
		Pacote pacote = pacotes.getPacote(nomePacote);
		if (pacote == null)
			return null;
		return pacote.getClasse(nomeClasse);
	}

	public GerenciadorPacotes getPacotes() {
		return pacotes;
	}

	public void setPacotes(GerenciadorPacotes pacotes) {
		this.pacotes = pacotes;
	}

	public void read() throws Exception {
		criaClassesDefault();
	}

	@SuppressWarnings("unchecked")
	public void read(String pathXmi) throws Exception {
		read();

		if (pathXmi == null) {
			throw new Exception("Argumentos Invalidos!");
		}

		SAXBuilder builder = new SAXBuilder();
		try {
			Document xmlDoc = builder.build(pathXmi);
			Element rootElement = xmlDoc.getRootElement();
			List<Element> children = rootElement.getChildren();

			try {
				read(new HashMap<String, Colecao>(), children);
			} catch (Exception e) {
				throw new Exception(e);
			}
		} catch (JDOMException e) {
			throw new Exception(e);
		} catch (IOException e) {
			throw new Exception(e);
		}
	}

	@SuppressWarnings("unchecked")
	private void read(Map<String, Colecao> colecoes, Element model)
			throws Exception {
		Pacote pacote = getPacotes().getPacotePadrao();

		List<Element> children = model.getChildren();
		for (Element child : children) {
			if (child.getName().equals(Constantes.PACKAGED_ELEMENT)) {
				List<Attribute> attributes = child.getAttributes();
				Attribute attribute = (Attribute) attributes.get(0);
				String value = attribute.getValue();

				if (value.equals(Constantes.UML_CLASS)) {
					Attribute attrName = child.getAttribute("name");
					String nome = attrName.getValue();

					if (nome.matches(Constantes.COLLECTION_PATTERN)) {

						Matcher matcher = Pattern.compile(
								Constantes.CONTEUDO_COLLECTION_PATTERN)
								.matcher(nome);
						matcher.find();
						String conteudoColecao = matcher.group();
						conteudoColecao = conteudoColecao.replaceAll("<", "")
								.replaceAll(">", "");
						Colecao colecao = new Colecao(child, conteudoColecao);
						colecoes.put(colecao.getId(), colecao);
					} else {
						Classe classe = new Classe(child);
						pacote.addClasse(classe);
					}
				} else if (value.equals(Constantes.UML_ENUM)) {
					Enumeration enumeration = new Enumeration(child);
					pacote.addEnumeration(enumeration);
				}
			}
		}
	}

	private void read(Map<String, Colecao> colecoes, List<Element> children)
			throws Exception {
		for (Element child : children) {
			if (child.getName().equals(Constantes.UML_MODEL)) {
				read(colecoes, child);
			}
		}

		List<Classe> classes = pacotes.getAllClasses();
		Iterator<?> it = colecoes.values().iterator();

		while (it.hasNext()) {
			Colecao colecao = (Colecao) it.next();
			Classe tipoConteudoColecao = TradutorXMI.getClassePorNome(classes,
					colecao.getTipoObjetosStr());
			colecao.setTipoObjetos(tipoConteudoColecao);
		}

		classes.addAll(colecoes.values());
		if (classes != null && !classes.isEmpty()) {
			for (Classe c : classes) {
				c.read(classes);
			}
		}

		setClasseMaeOclType(classes);
	}

	private void setClasseMaeOclType(List<Classe> classes) {
		Classe bool = getClasse("Boolean");
		Classe oclType = new Classe("OclType");

		Metodo oclIsNew = new Metodo(Constantes.OP_OCL_IS_NEW, bool);
		Metodo oclIsUndefined = new Metodo(Constantes.OP_OCL_IS_UNDEFINED, bool);
		Metodo oclIsKindOf = new Metodo(Constantes.OP_OCL_IS_KIND_OF, bool,
				oclType);
		Metodo oclIsTypeOf = new Metodo(Constantes.OP_OCL_IS_TYPE_OF, bool,
				oclType);

		try {
			oclType.addMetodo(oclIsNew);
			oclType.addMetodo(oclIsUndefined);
			oclType.addMetodo(oclIsKindOf);
			oclType.addMetodo(oclIsTypeOf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Classe classe : classes) {
			if (!tiposPrimitivos.contains(classe)) {
				if (classe.getClasseMae() == null) {
					classe.setClasseMae(oclType);
				}
			}
		}
	}

	private void criaClassesDefault() throws Exception {
		Classe number = new Classe("Number");
		Classe string = new Classe("String");
		Classe real = new Classe("Double");
		Classe integer = new Classe("Integer");
		Classe bool = new Classe("Boolean");

		Metodo modulos = new Metodo("mod", integer, integer);
		Metodo div = new Metodo("div", integer, integer);
		Metodo abs = new Metodo("abs", real);
		Metodo max = new Metodo("max", real, number);
		Metodo min = new Metodo("min", real, number);
		Metodo round = new Metodo("round", integer);
		Metodo floor = new Metodo("floor", integer);
		Metodo concat = new Metodo("concat", "__add__(",  string, string);
		Metodo size = new Metodo("size", "__len__(",  integer);
		Metodo lower = new Metodo("toLower", "lower(",  string);
		Metodo upper = new Metodo("toUpper", "upper(", string);
		Metodo substring = new Metodo("substring", "__getSlice__(",  string, integer, integer);

		try {
			number.addMetodo(modulos);
			number.addMetodo(div);
			number.addMetodo(abs);
			number.addMetodo(max);
			number.addMetodo(min);
			number.addMetodo(round);
			number.addMetodo(floor);
			string.addMetodo(concat);
			string.addMetodo(size);
			string.addMetodo(lower);
			string.addMetodo(upper);
			string.addMetodo(substring);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		real.setClasseMae(number);
		integer.setClasseMae(number);

		try {
			tiposPrimitivos.add(number);
			tiposPrimitivos.add(string);
			tiposPrimitivos.add(real);
			tiposPrimitivos.add(integer);
			tiposPrimitivos.add(bool);

			pacotes.getPacotePadrao().addClasses(tiposPrimitivos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
