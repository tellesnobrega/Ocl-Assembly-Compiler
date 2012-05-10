package gerador.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Attribute;
import org.jdom.Element;

public class Classe extends Elemento {
	private Classe classeMae;

	protected boolean abstrata;

	protected String nome;
	protected VisibilidadeKind visibilidade;
	protected Map<String, Atributo> atributos;
	protected Map<String, Metodo> metodos;

	public Classe(Element element) throws Exception {
		super(element);

		this.atributos = new HashMap<String, Atributo>();
		this.metodos = new HashMap<String, Metodo>();

		Attribute attrName = element.getAttribute("name");
		Attribute attrVis = element.getAttribute("visibility");

		setNome(attrName.getValue());
		setVisibilidade(attrVis.getValue());
	}

	public Classe(String nome) {
		super(nome);

		this.atributos = new HashMap<String, Atributo>();
		this.metodos = new HashMap<String, Metodo>();

		this.nome = nome;
		this.visibilidade = VisibilidadeKind.PUBLIC;
	}

	public boolean ehColecao() {
		return false;
	}

	public List<Atributo> getAtributos() {
		return new ArrayList<Atributo>(atributos.values());
	}

	public List<Metodo> getMetodos() {
		return new ArrayList<Metodo>(metodos.values());
	}

	public void setVisibilidade(String visibilidade) {
		this.visibilidade = VisibilidadeKind.getByDescricao(visibilidade);
	}

	public void addAtributo(Atributo atributo) throws Exception {
		if (atributos.containsKey(atributo.getNome())) {
			throw new Exception("Atributo " + atributo.getNome()
					+ " ja existente na classe " + nome + "!");
		}
		atributos.put(atributo.getNome(), atributo);
	}

	public Atributo getAtributo(String nome) {
		Atributo atributo = this.atributos.get(nome);
		if (atributo != null)
			return atributo;
		if (classeMae != null)
			atributo = classeMae.getAtributo(nome);
		if (atributo != null
				&& atributo.getVisibilidade().equals(VisibilidadeKind.PRIVATE))
			atributo = null;
		return atributo;
	}

	public void addMetodo(Metodo metodo) throws Exception {
		if (metodos.containsKey(metodo.getNome())) {
			throw new Exception("Metodo " + metodo.getNome()
					+ " ja existente na classe " + nome + "!");
		}
		metodos.put(metodo.getNome(), metodo);
	}

	public Metodo getMetodo(String nome) {
		Metodo metodo = metodos.get(nome);
		if (metodo != null)
			return metodo;
		if (classeMae != null)
			metodo = classeMae.getMetodo(nome);
		if (metodo != null
				&& metodo.getVisibilidade().equals(VisibilidadeKind.PRIVATE))
			metodo = null;
		return metodo;
	}

	public boolean isTypeOf(Classe outra) {
		return existeAncestralEmComum(this, outra);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Classe getClasseMae() {
		return classeMae;
	}

	public void setAbstrata(boolean abstrata) {
		this.abstrata = abstrata;
	}

	public boolean ehAbstrata() {
		return abstrata;
	}

	public void setClasseMae(Classe classeMae) {
		this.classeMae = classeMae;
	}

	public VisibilidadeKind getVisibilidade() {
		return visibilidade;
	}

	public boolean temAtributo(String nome) {
		return getAtributo(nome) != null;
	}

	public boolean temMetodo(String nomeOp) {
		return getMetodo(nomeOp) != null;
	}

	public boolean ehFilhoDe(Classe outra) {
		Classe mae = this.classeMae;
		while (mae != null) {
			if (mae.equals(outra))
				return true;
			mae = mae.getClasseMae();
		}
		return false;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classe other = (Classe) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public void read(List<Classe> classes) throws Exception {
		if (this.element != null) {
			List<Element> children = this.element.getChildren();

			if (children != null && !children.isEmpty()) {
				for (Element child : children) {

					List<Attribute> attributes2 = child.getAttributes();
					Attribute attr = (Attribute) attributes2.get(0);
					String value = attr.getValue();

					if (value.equals("uml:Property")) {
						Atributo atributo = new Atributo(child, classes);
						this.addAtributo(atributo);
					} else if (value.equals("uml:Operation")) {
						Metodo metodo = new Metodo(child, classes);
						this.addMetodo(metodo);
					} else if (value.equals("uml:Generalization")) {
						List<Attribute> attributes = child.getAttributes();
						Attribute xmiId = (Attribute) attributes.get(3);
						String id = xmiId.getValue();
						Classe classeMae = TradutorXMI.getClassePorId(classes,
								id);

						this.setClasseMae(classeMae);
					}
				}
			}
		}
	}

	private static boolean existeAncestralEmComum(Classe a, Classe b) {
		Classe atual = b;

		while (atual != null) {
			Classe outra = a;
			while (outra != null) {
				if (outra.equals(atual) && !outra.getNome().equals("OclType"))
					return true;
				outra = outra.getClasseMae();
			}
			atual = atual.getClasseMae();
		}

		return false;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
