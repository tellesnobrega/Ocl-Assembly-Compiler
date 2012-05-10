package gerador.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pacote {
	private String nome;
	private Map<String, Classe> classes;
	private Map<String, Enumeration> enumerations;

	public Pacote(String nome) {
		this.nome = nome;

		this.classes = new HashMap<String, Classe>();
		this.enumerations = new HashMap<String, Enumeration>();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public boolean temClasse(String nome) {
		return classes.containsKey(nome);
	}

	public boolean temEnum(String nome) {
		return enumerations.containsKey(nome);
	}

	public Classe getClasse(String nome) {
		return classes.get(nome);
	}

	public Enumeration getEnumeration(String nome) {
		return enumerations.get(nome);
	}

	public void addClasse(Classe c) throws Exception {
		if (classes.containsKey(c.getNome())) {
			throw new Exception("Classe " + c.getNome()
					+ " ja existente no pacote");
		}
		classes.put(c.getNome(), c);
	}

	public void addEnumeration(Enumeration e) throws Exception {
		if (classes.containsKey(e.getNome())) {
			throw new Exception("Enumeration " + e.getNome()
					+ " ja existente no pacote");
		}
		classes.put(e.getNome(), e);
		enumerations.put(e.getNome(), e);
	}

	public void addClasses(List<Classe> classes) throws Exception {
		for (Classe c : classes) {
			addClasse(c);
		}
	}

	public List<Enumeration> getEnumerations() {
		return new ArrayList<Enumeration>(enumerations.values());
	}

	public List<Classe> getClasses() {
		return new ArrayList<Classe>(classes.values());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Pacote other = (Pacote) obj;
		if (classes == null) {
			if (other.classes != null)
				return false;
		} else if (!classes.equals(other.classes))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
