package br.com.silas.votenolivro.dto;

import java.util.ArrayList;
import java.util.List;

public class VotacaoDto {

	private List<Integer> ids;
	
	private Integer usuario;
	
	private Integer votoAtual;

	public VotacaoDto() {
	}
	
	public VotacaoDto(Integer usuario) {
		this.usuario = usuario;
	}
	
	public List<Integer> getIds() {
		if (ids == null) {
			ids = new ArrayList<>();
		}
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getVotoAtual() {
		return votoAtual;
	}

	public void setVotoAtual(Integer votoAtual) {
		this.votoAtual = votoAtual;
	}
}