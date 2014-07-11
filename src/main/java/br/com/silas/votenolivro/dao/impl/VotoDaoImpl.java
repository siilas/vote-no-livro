package br.com.silas.votenolivro.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dao.VotoDao;
import br.com.silas.votenolivro.model.Voto;

@Repository
@Transactional
public class VotoDaoImpl extends GenericDaoImpl<Voto> implements VotoDao {
	
	@Override
	public Voto buscarPorLivro(Integer livro) {
		String sql = "FROM Voto V WHERE V.livro.id = :livro";
		Query query = getSession().createQuery(sql);
		query.setParameter("livro", livro);
		return (Voto) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Voto> buscarRanking() {
		String sql = "FROM Voto V ORDER BY V.quantidade DESC";
		Query query = getSession().createQuery(sql);
		return query.list();
	}
}