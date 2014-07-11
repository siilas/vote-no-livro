package br.com.silas.votenolivro.dao;

import java.util.List;

public abstract interface GenericDao<T> {

	void salvar(T entidade);
	
	void deletar(T entidade);
	
	T buscarPorId(Integer id);
	
	List<T> buscarTodos();
}