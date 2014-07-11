package br.com.silas.votenolivro.dao;

import java.util.List;

import br.com.silas.votenolivro.model.Livro;

public interface LivroDao extends GenericDao<Livro> {

	List<Livro> buscarLivros(int limite);
	
	List<Livro> buscarLivrosDiferentesDe(List<Integer> ids, int limite);
}