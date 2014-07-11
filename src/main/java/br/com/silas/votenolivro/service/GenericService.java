package br.com.silas.votenolivro.service;

import java.util.List;

public abstract interface GenericService<T> {

	void salvar(T entidade);
	
	void deletar(Integer id);
	
	T buscarPorId(Integer id);
	
	List<T> buscarTodos();
}