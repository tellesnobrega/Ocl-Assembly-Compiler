package gerador.parser;

import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

public abstract class Elemento {
	protected String id;
	protected List<Attribute> attributes;
	protected Element element;

	public Elemento() {}

	public Elemento(String id) {
		try {
			this.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Elemento(Element model) throws Exception {
		List attributes = model.getAttributes();
		Attribute xmiId = (Attribute) attributes.get(1);
		String id = xmiId.getValue();

		this.setId(id);
		this.setAttributes(attributes);
		this.setElement(model);

	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws Exception {
		if (id == null || id.equals("")) {
			throw new Exception("Elemento nulo ou vazio.");
		}
		this.id = id;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elemento other = (Elemento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
