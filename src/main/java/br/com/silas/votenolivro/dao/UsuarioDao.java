package br.com.silas.votenolivro.dao;

import br.com.silas.votenolivro.model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario> {

	Usuario buscarPorEmail(String email);
}