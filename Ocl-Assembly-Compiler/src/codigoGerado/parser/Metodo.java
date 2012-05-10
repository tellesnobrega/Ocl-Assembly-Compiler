package gerador.parser;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

public class Metodo extends Elemento {
	private boolean estatico;
	private boolean abstrato;
	private boolean metodoFinal;

	private String nome;
	private String codigoPython;
	private VisibilidadeKind visibilidade;
	private Classe tipoRetorno;
	private List<Parametro> parametros;

	public Metodo(String nomeOp, Classe tipoRetorno, Classe... tiposParametros) {
		this(nomeOp);
		this.tipoRetorno = tipoRetorno;
		for (Classe classe : tiposParametros) {
			addParametro(new Parametro("", classe));
		}
	}
	
	public Metodo(String nomeOp, String codigoPython, Classe tipoRetorno, Classe... tiposParametros) {
		this(nomeOp);
		this.tipoRetorno = tipoRetorno;
		this.codigoPython = codigoPython;
		for (Classe classe : tiposParametros) {
			addParametro(new Parametro("", classe));
		}
	}

	public Metodo(String nome) {
		this.parametros = new ArrayList<Parametro>();
		this.nome = nome;
		this.visibilidade = VisibilidadeKind.PUBLIC;
	}

	@SuppressWarnings("unchecked")
	public Metodo(Element elemento, List<Classe> classes)
			throws Exception {
		super(elemento);

		Attribute attrName = elemento.getAttribute("name");
		Attribute attrVis = elemento.getAttribute("visibility");

		this.parametros = new ArrayList<Parametro>();
		this.setNome(attrName.getValue());
		this.setVisibilidade(attrVis.getValue());
		this.read(elemento.getChildren(), classes);
	}

	public String getNome() {
		return nome;
	}

	public void setVisibilidade(String visibilidade) {
		this.visibilidade = VisibilidadeKind.getByDescricao(visibilidade);
	}

	public VisibilidadeKind getVisibilidade() {
		return visibilidade;
	}

	public void setTipoRetorno(Classe tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}

	public Classe getTipoRetorno() {
		return tipoRetorno;
	}

	public void setMetodoFinal(boolean metodoFinal) {
		this.metodoFinal = metodoFinal;
	}

	public boolean isMetodoFinal() {
		return metodoFinal;
	}

	public void setAbstrato(boolean abstrato) {
		this.abstrato = abstrato;
	}

	public boolean isAbstrato() {
		return abstrato;
	}

	public void setEstatico(boolean estatico) {
		this.estatico = estatico;
	}

	public boolean isEstatico() {
		return estatico;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}

	public int getQuantidadeParametros() {
		return parametros.size();
	}

	public void addParametro(Parametro p) {
		parametros.add(p);
	}

	private void read(List<Element> children, List<Classe> classes)
			throws Exception {
		if (children != null && !children.isEmpty()) {
			for (Element child : children) {
				Atributo atributo = new Atributo(child, classes);
				Attribute attribute = child.getAttribute("direction");

				if (attribute != null) {
					if (attribute.getValue().equals("return")) {
						setTipoRetorno(atributo.getTipo());
					} else {
						parametros.add(new Parametro(atributo.getNome(),
								atributo.getTipo()));
					}
				} else {
					parametros.add(new Parametro(atributo.getNome(), atributo
							.getTipo()));
				}
			}
		}

		if (tipoRetorno == null) {
			setTipoRetorno(GerenciadorEntidades.getInstance().getClasse(
					Constantes.VOID));
		}
	}

	public String getCodigoPython() {
		return codigoPython;
	}

	public void setCodigoPython(String codigoPython) {
		this.codigoPython = codigoPython;
	}
}
