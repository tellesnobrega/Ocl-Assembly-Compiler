package gerador.semantico;

public class Constant {
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	
	public static final String ANALISADOR_LEXICO_PATH = "src" + FILE_SEPARATOR + "analisador" + FILE_SEPARATOR + "AnalisadorLexico.flex";
	public static final String ANALISADOR_SINTATICO_PATH = "src" + FILE_SEPARATOR + "analisador" + FILE_SEPARATOR + "AnalisadorSintatico.cup"; 
	
	public static final String CODIGO_GERADO_PATH = "src" + FILE_SEPARATOR + "codigoGerado";
	
	public static final String EXEMPLO_PATH = "src" + FILE_SEPARATOR + "exemplo" + FILE_SEPARATOR;
}