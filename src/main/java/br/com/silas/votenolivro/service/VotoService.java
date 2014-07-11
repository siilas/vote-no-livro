package br.com.silas.votenolivro.service;

import java.util.List;

import br.com.silas.votenolivro.model.Voto;

public interface VotoService extends GenericService<Voto> {

	void contabilizarVoto(Integer livro);
	
	List<Voto> buscarRanking();
}