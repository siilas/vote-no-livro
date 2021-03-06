package br.com.silas.votenolivro.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dao.PontoDao;
import br.com.silas.votenolivro.model.Ponto;

@Repository
@Transactional
public class PontoDaoImpl extends GenericDaoImpl<Ponto> implements PontoDao {

	@Override
	public Ponto buscarPorUsuario(Integer usuario) {
		String sql = "FROM Ponto P WHERE P.usuario.id = :usuario";
		Query query = getSession().createQuery(sql);
		query.setParameter("usuario", usuario);
		return (Ponto) query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Ponto> buscarPontuacao() {
		String sql = "FROM Ponto P ORDER BY P.quantidade DESC";
		Query query = getSession().createQuery(sql);
		return query.list();
	}
}