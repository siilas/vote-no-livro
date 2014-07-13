package br.com.silas.votenolivro.dao;

import java.util.List;

import br.com.silas.votenolivro.model.Voto;

public interface VotoDao extends GenericDao<Voto> {

	Voto buscarPorLivro(Integer livro);
	
	List<Voto> buscarRanking();
}