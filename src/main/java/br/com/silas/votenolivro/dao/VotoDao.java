package br.com.silas.votenolivro.dao;

import br.com.silas.votenolivro.model.Voto;

public interface VotoDao extends GenericDao<Voto> {

	Voto buscarPorLivro(Integer livro);	
}