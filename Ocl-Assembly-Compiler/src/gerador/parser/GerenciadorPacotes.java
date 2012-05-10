package gerador.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GerenciadorPacotes {
	private HashMap<String, Pacote> pacotes;

	public GerenciadorPacotes() {
		pacotes = new HashMap<String, Pacote>();
		pacotes.put(Constantes.PACOTE_PADRAO, new Pacote(
				Constantes.PACOTE_PADRAO));
	}

	public void addPacote(Pacote p) throws Exception {
		if (pacotes.containsKey(p.getNome())) {
			throw new Exception("Ja existe pacote " + p.getNome() + "!");
		}
		pacotes.put(p.getNome(), p);
	}

	public Pacote getPacote(String nome) {
		return pacotes.get(nome);
	}

	public Pacote getPacotePadrao() {
		return pacotes.get(Constantes.PACOTE_PADRAO);
	}

	public List<Classe> getAllClasses() {
		List<Classe> classes = new ArrayList<Classe>();

		ArrayList<Pacote> packages = new ArrayList<Pacote>(pacotes.values());
		for (Pacote pacote : packages) {
			classes.addAll(pacote.getClasses());
			//classes.addAll(pacote.getEnumerations());
		}

		return classes;
	}
	
	public List<Enumeration> getAllEnumerations() {
		List<Enumeration> enumerations = new ArrayList<Enumeration>();

		ArrayList<Pacote> packages = new ArrayList<Pacote>(pacotes.values());
		for (Pacote pacote : packages)
			enumerations.addAll(pacote.getEnumerations());

		return enumerations;
	}
}