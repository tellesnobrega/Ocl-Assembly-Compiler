package gerador.parser;

public class Parametro {
	private String nome;
	private Classe tipo;

	public Parametro(String nome, Classe tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setTipo(Classe tipo) {
		this.tipo = tipo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
