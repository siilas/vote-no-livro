package br.com.silas.votenolivro.service;

import java.util.List;

import br.com.silas.votenolivro.model.Ponto;

public interface PontoService extends GenericService<Ponto> {

	void contabilizarPonto(Integer usuario);
	
	List<Ponto> buscarPontuacao();
}