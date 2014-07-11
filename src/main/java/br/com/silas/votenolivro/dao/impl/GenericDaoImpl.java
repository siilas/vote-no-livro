package br.com.silas.votenolivro.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.silas.votenolivro.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void salvar(T entidade) {
		getSession().saveOrUpdate(entidade);
	}

	@Override
	public void deletar(T entidade) {
		getSession().delete(entidade);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T buscarPorId(Integer id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		Criteria criteria = getSession().createCriteria(clazz);
		return criteria.list();
	}
}