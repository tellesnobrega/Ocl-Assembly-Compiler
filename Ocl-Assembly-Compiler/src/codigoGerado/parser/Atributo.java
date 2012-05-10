package gerador.parser;

import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

public class Atributo extends Elemento {
	private boolean estatico;
	private VisibilidadeKind visibilidade;
	private String nome;
	private Classe tipo;

	public Atributo(String nome, Classe tipo, VisibilidadeKind visibilidade) {
		this.nome = nome;
		this.tipo = tipo;
		this.visibilidade = visibilidade;
	}

	public Atributo(Element elemento, List<Classe> classes)
			throws Exception {
		super(elemento);

		Attribute attrName = elemento.getAttribute("name");
		Attribute attrVis = elemento.getAttribute("visibility");
		Attribute attrType = elemento.getAttribute("type");

		if (attrName != null) {
			this.setNome(attrName.getValue());
		}
		this.setVisibilidade(attrVis.getValue());
		this.traduz(attrType, classes);

		if (attrName != null && !attrName.getValue().trim().isEmpty()) {
			this.setNome(attrName.getValue());
		} else {
			this.setNome(TradutorXMI.getNomeAtributoPadraoUML(this.getTipo()));
		}
	}

	public boolean ehEstatico() {
		return estatico;
	}

	public void setEstatico(boolean estatico) {
		this.estatico = estatico;
	}

	public void setVisibilidade(String visibilidade) {
		this.visibilidade = VisibilidadeKind.getByDescricao(visibilidade);
	}

	public VisibilidadeKind getVisibilidade() {
		return visibilidade;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

	public Classe getTipo() {
		return tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	private void traduz(Attribute attrType, List<Classe> classes)
			throws Exception {
		if (attrType == null) {
			String value = "";

			Element child = element.getChild("type");
			Attribute attribute = child.getAttribute("href");
			String attrValue = attribute.getValue();
			int index = attrValue.indexOf("#");
			value = attrValue.substring(index + 1, attrValue.length());

			if (value.equals("Double") || value.equals("Float")) {
				value = "Real";
			}

			Classe classe = TradutorXMI.getClassePorId(classes, value);
			this.setTipo(classe);
		} else {
			Classe classe = TradutorXMI.getClassePorId(classes,
					attrType.getValue());

			if (classe != null) {
				this.setTipo(classe);

				Element lowerValue = element
						.getChild(Constantes.LOWER_VALUE);
				Element upperValue = element
						.getChild(Constantes.UPPER_VALUE);

				if (lowerValue != null) {
					Attribute lowerValueAtt = lowerValue
							.getAttribute(Constantes.LOWER_VALUE_ATTR);
					if (lowerValueAtt != null) {
						if (lowerValueAtt.getValue().equals(
								Constantes.MANY)
								|| Integer.valueOf(lowerValueAtt.getValue()) > 1) {
							setTipo(new Colecao(classe));
						}
					}
				}

				if (upperValue != null) {
					Attribute upperValueAtt = upperValue
							.getAttribute(Constantes.UPPER_VALUE_ATTR);

					if (upperValueAtt != null) {
						if (upperValueAtt.getValue().equals(
								Constantes.MANY)
								|| Integer.valueOf(upperValueAtt.getValue()) > 1) {
							this.setTipo(new Colecao(classe));
						}
					}
				}
			} else {
				throw new Exception("Elemento nao encontrado.");
			}
		}
	}
}
