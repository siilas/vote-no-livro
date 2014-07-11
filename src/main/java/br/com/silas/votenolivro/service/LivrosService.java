package br.com.silas.votenolivro.service;

import java.util.List;

import br.com.silas.votenolivro.model.Livro;

public interface LivrosService extends GenericService<Livro> {
	
	List<Livro> buscarLivrosInicias();
	
	List<Livro> buscarLivrosDiferentesDe(List<Integer> ids);
}