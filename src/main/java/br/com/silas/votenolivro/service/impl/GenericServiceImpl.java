package br.com.silas.votenolivro.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dao.GenericDao;
import br.com.silas.votenolivro.service.GenericService;

public abstract class GenericServiceImpl<T> implements GenericService<T> {

	@Override
	@Transactional
	public void salvar(T entidade) {
		getDao().salvar(entidade);
	}

	@Override
	@Transactional
	public void deletar(Integer id) {
		T entidade = getDao().buscarPorId(id);
		getDao().deletar(entidade);
	}

	@Override
	@Transactional
	public T buscarPorId(Integer id) {
		return getDao().buscarPorId(id);
	}
	
	@Transactional
	public List<T> buscarTodos() {
		return getDao().buscarTodos();
	}
	
	public abstract GenericDao<T> getDao();
}