package br.com.silas.votenolivro.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dao.LivroDao;
import br.com.silas.votenolivro.model.Livro;

@Repository
@Transactional
public class LivroDaoImpl extends GenericDaoImpl<Livro> implements LivroDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Livro> buscarLivrosDiferentesDe(List<Integer> ids, int limite) {
		String sql = "FROM Livro L WHERE L.id NOT IN (:ids) ORDER BY RANDOM() ";
		Query query = getSession().createQuery(sql);
		query.setParameterList("ids", ids);
		query.setMaxResults(limite);
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Livro> buscarLivros(int limite) {
		String sql = "FROM Livro L ORDER BY RANDOM()";
		Query query = getSession().createQuery(sql);
		query.setMaxResults(limite);
		return query.list();
	}
}