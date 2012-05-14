package gerador.semantico;
public class StereotypeNameClass {

	private String tipo;
	private String codigo;

	public StereotypeNameClass(Object name) {
		String n = (String) name;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}
}
