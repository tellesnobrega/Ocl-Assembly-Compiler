package gerador.parser;

public enum VisibilidadeKind {
	PUBLIC("Public"), PRIVATE("Private"), PROTECTED("Protected");

	private String descricao;

	VisibilidadeKind(String descricao) {
		this.setDescricao(descricao);
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static VisibilidadeKind getByDescricao(String descricao) {
		for (VisibilidadeKind v : values()) {
			if (v.getDescricao().equalsIgnoreCase(descricao)) {
				return v;
			}
		}
		return null;
	}
}
