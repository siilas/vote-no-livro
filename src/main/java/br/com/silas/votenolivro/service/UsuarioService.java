package br.com.silas.votenolivro.service;

import br.com.silas.votenolivro.model.Usuario;

public interface UsuarioService extends GenericService<Usuario> {

	Usuario buscarPorEmail(String email);
	
	void atualizaOuInsereUsuarioPorEmail(Usuario usuario);
}