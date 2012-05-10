package gerador.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradutorXMI {

    private static TradutorXMI instance;

    private TradutorXMI() {
    }

    public static TradutorXMI getInstance() {
        if (instance == null)
            instance = new TradutorXMI();
        return instance;
    }

    public void traduz(String arquivoXmi) throws Exception {
        GerenciadorEntidades gerenciadorEntidades = GerenciadorEntidades.getInstance();
        
        Map<String, Enumeration> enums = new HashMap<String, Enumeration>();
        
        try {
            gerenciadorEntidades.read(arquivoXmi);
            
            for (Enumeration enumeration : gerenciadorEntidades.getPacotes().getAllEnumerations())
            	enums.put(enumeration.getNome(), enumeration);
            
            for (Classe classe : gerenciadorEntidades.getPacotes().getAllClasses()) {
                Enumeration enume;
                if ((enume = enums.get(classe.getNome())) != null) {
                	for (String atr : enume.getEnumList()) {
                		Atributo a = new Atributo(atr, classe, VisibilidadeKind.PUBLIC);
                		a.setEstatico(true);
						classe.addAtributo(a);
					}
                }
            }
            
        } catch (Exception e) {
            throw new Exception("A leitura do arquivo XML falhou!", e);
        }
    }

    public static Classe getClassePorId(List<Classe> classes, String id) {
        if (classes != null && !classes.isEmpty()) {
            for (Classe classe : classes) {
                if (classe.getId().equals(id)) {
                    return classe;
                }
            }
        }
        return null;
    }

    public static Classe getClassePorNome(List<Classe> classes, String nome) {
        if (classes != null && !classes.isEmpty()) {
            for (Classe classe : classes) {
                if (classe.getNome().equalsIgnoreCase(nome)) {
                    return classe;
                }
            }
        }
        return null;
    }

    public static String getNomeAtributoPadraoUML(Classe classeDoAtributo) {
        String nomeAtributo = classeDoAtributo.ehColecao() ? ((Colecao) classeDoAtributo)
                .getTipoObjetos().getNome() : classeDoAtributo.getNome();
        String caracterInicial = nomeAtributo.substring(0, 1);
        return nomeAtributo.replaceFirst(caracterInicial,
                caracterInicial.toLowerCase());

    }

}