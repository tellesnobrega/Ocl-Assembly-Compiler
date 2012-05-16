package gerador.semantico;

import gerador.AnalisadorSemantico;
import gerador.parser.Atributo;
import gerador.parser.Classe;
import gerador.parser.Colecao;
import gerador.parser.Metodo;

public class PropertyCallClass {

	private Classe tipo;
	private String codigo;
	private AnalisadorSemantico analisador = AnalisadorSemantico.getInstance();

	public PropertyCallClass(int linha, int coluna, Object pn, Object opc) {
		PathNameClass pathname = (PathNameClass) pn;
		PropertyOptCallClass o = (PropertyOptCallClass) opc;

		boolean atualizouContexto = false;
		boolean alias = false;

		try {
			analisador.setContexto(0, 0, pathname.getValue());
			this.tipo = analisador.getContexto();
			atualizouContexto = true;
		} catch (Exception e) {
		}
		
		
		if (o == null && !atualizouContexto) {
			if (pathname.getCodigo().equalsIgnoreCase("allInstances")) {
				this.tipo = new Colecao(analisador.getContexto());
			} else if (alias) {
				analisador.setContexto();
			} else if (analisador.getContexto() instanceof Colecao) {
				String op = analisador.ultimaOperacaoSobreColecao;
				if (!((Colecao) analisador.getContexto()).getTipoObjetos()
						.temAtributo(pathname.getCodigo())) {
					throw new RuntimeException("O atributo "
							+ pathname.getCodigo()
							+ AnalisadorSemantico.identificaErro(linha, coluna)
							+ "nao existe no contexto "
							+ ((Colecao) analisador.getContexto())
									.getTipoObjetos().getNome());
				}
			} else {
				System.out.println(pathname.getCodigo());
				erroAtributo(pathname, linha, coluna);
			}

			if (alias) {
				System.out.println(alias);
				this.tipo = analisador.getContexto();
			} else if (analisador.getContexto() instanceof Colecao) {
				this.tipo = ((Colecao) analisador.getContexto())
						.getTipoObjetos().getAtributo(pathname.getCodigo())
						.getTipo();
			} else {
				this.tipo = analisador.getContexto()
						.getAtributo(pathname.getCodigo()).getTipo();
			}
		} else if (!atualizouContexto) {
			if (pathname.getCodigo().equalsIgnoreCase("allInstances")) {
				this.tipo = new Colecao(analisador.getContexto());
			} else if (alias) {
				analisador.setContexto();
			} else if (analisador.getContexto() instanceof Colecao) {
				String op = analisador.ultimaOperacaoSobreColecao;
				if (op.equals("first") || op.equals("last")) {
					PropertyOptCallClass castOpc = (PropertyOptCallClass) opc;
					Metodo metodo = ((Colecao) analisador.getContexto())
							.getTipoObjetos().getMetodo(pathname.getCodigo());
					if (metodo != null) {
						erroMetodo(metodo, castOpc, pathname, linha, coluna);
						this.tipo = ((Colecao) analisador.getContexto())
								.getTipoObjetos()
								.getMetodo(pathname.getCodigo())
								.getTipoRetorno();
					} else {
						Atributo atributo = ((Colecao) analisador.getContexto())
								.getTipoObjetos().getAtributo(
										pathname.getCodigo());
						this.tipo = ((Colecao) analisador.getContexto())
								.getTipoObjetos()
								.getAtributo(pathname.getCodigo()).getTipo();
					}
				} else if (!analisador.getContexto().temMetodo(
						pathname.getCodigo())) {
					throw new RuntimeException("O metodo "
							+ pathname.getCodigo()
							+ AnalisadorSemantico.identificaErro(linha, coluna)
							+ "nao existe no contexto "
							+ analisador.getContexto().getNome());
				}
			} else if (!analisador.getContexto()
					.temMetodo(pathname.getCodigo())) {
				throw new RuntimeException("O metodo " + pathname.getCodigo()
						+ AnalisadorSemantico.identificaErro(linha, coluna)
						+ "nao existe no contexto "
						+ analisador.getContexto().getNome());
			} else {
				PropertyOptCallClass castOpc = (PropertyOptCallClass) opc;
				Metodo metodo = analisador.getContexto().getMetodo(
						pathname.getCodigo());
				if (metodo != null) {
					erroMetodo(metodo, castOpc, pathname, linha, coluna);
					this.tipo = analisador.getContexto()
							.getMetodo(pathname.getCodigo()).getTipoRetorno();
				} else {
					Atributo atributo = analisador.getContexto().getAtributo(
							pathname.getCodigo());
					this.tipo = analisador.getContexto()
							.getAtributo(pathname.getCodigo()).getTipo();
				}
			}
		}

		if (atualizouContexto || alias)
			analisador.retrocedeContexto();

	}

	private void erroAtributo(PathNameClass pathname, int linha, int coluna) {
		if (!analisador.getContexto().temAtributo(pathname.getCodigo()))
			throw new RuntimeException("O atributo " + pathname.getCodigo()
					+ AnalisadorSemantico.identificaErro(linha, coluna)
					+ "nao existe no contexto "
					+ analisador.getContexto().getNome());
	}

	private void erroMetodo(Metodo metodo, PropertyOptCallClass castOpc,
			PathNameClass pathname, int linha, int coluna) {
		if (metodo.getQuantidadeParametros() != castOpc.getParametros().size()) {
			throw new RuntimeException("O metodo " + pathname.getCodigo()
					+ AnalisadorSemantico.identificaErro(linha, coluna)
					+ "do contexto " + analisador.getContexto().getNome()
					+ " recebe " + metodo.getQuantidadeParametros()
					+ " e foram passados " + castOpc.getParametros().size()
					+ " parametros.");
		}
		for (int i = 0; i < metodo.getQuantidadeParametros(); i++) {
			if (!castOpc.getParametros().get(i).getNome()
					.equals(metodo.getParametros().get(i).getTipo().getNome())) {
				throw new RuntimeException("O metodo " + pathname.getCodigo()
						+ AnalisadorSemantico.identificaErro(linha, coluna)
						+ "do contexto " + analisador.getContexto().getNome()
						+ " nao se aplica para os argumentos passados. ("
						+ castOpc.getParametros().get(i).getNome() + ")");
			}
		}
		this.tipo = analisador.getGerenciador().getClasse("Integer");
	}

	public PropertyCallClass(Object a) {
		PathNameClass path = (PathNameClass) a;

	}

	public String getCodigo() {
		return codigo;
	}

	public Classe getTipo() {
		return tipo;
	}
}
