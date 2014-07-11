package br.com.silas.votenolivro.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dao.UsuarioDao;
import br.com.silas.votenolivro.model.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario> implements UsuarioDao {

	@Override
	public Usuario buscarPorEmail(String email) {
		String sql = "FROM Usuario U WHERE U.email = :email";
		Query query = getSession().createQuery(sql);
		query.setParameter("email", email);
		return (Usuario) query.uniqueResult();
	}
}