package gerador.parser;

import java.util.LinkedList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

public class Enumeration extends Classe {
	private List<String> enumList;

	@SuppressWarnings("unchecked")
	public Enumeration(Element elemento) throws Exception {
		super(elemento);
		setEnumList(new LinkedList<String>());

		Attribute attrName = elemento.getAttribute("name");
		Attribute attrVis = elemento.getAttribute("visibility");

		this.setNome(attrName.getValue());
		this.setVisibilidade(attrVis.getValue());

		readEnum(elemento.getChildren());
	}

	public void setEnumList(List<String> enumList) {
		this.enumList = enumList;
	}

	public List<String> getEnumList() {
		return enumList;
	}

	private void readEnum(List<Element> children) {
		if (children != null && !children.isEmpty()) {
			for (Element child : children) {
				Attribute attribute = child.getAttribute("name");
				String value = attribute.getValue();
				
				enumList.add(value);
			}
		}
	}
}
