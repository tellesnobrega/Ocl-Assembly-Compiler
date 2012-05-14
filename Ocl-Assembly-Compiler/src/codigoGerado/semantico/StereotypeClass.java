package gerador.semantico;
public class StereotypeClass {

	private String tipo;
	private String codigo;

	public StereotypeClass(Object obj) {
		if(((String) obj).equalsIgnoreCase("PRE")) {
			
		}else {
			
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}
}
