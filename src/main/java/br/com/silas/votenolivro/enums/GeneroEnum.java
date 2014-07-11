package br.com.silas.votenolivro.enums;

public enum GeneroEnum {

	AVENTURA(1, "GeneroEnum.AVENTURA.label"),
	TERROR(2, "GeneroEnum.TERROR.label"),
	DRAMA(3, "GeneroEnum.DRAMA.label"),
	FICCAO(4, "GeneroEnum.FICCAO.label"),
	FANTASIA(5, "GeneroEnum.FANTASIA.label"),
	ROMANCE(6, "GeneroEnum.ROMANCE.label");
	
	private Integer codigo;
	private String descricao;
	
	private GeneroEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
}