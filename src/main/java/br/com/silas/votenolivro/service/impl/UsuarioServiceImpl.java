package br.com.silas.votenolivro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dao.GenericDao;
import br.com.silas.votenolivro.dao.UsuarioDao;
import br.com.silas.votenolivro.model.Usuario;
import br.com.silas.votenolivro.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public GenericDao<Usuario> getDao() {
		return usuarioDao;
	}
	
	@Override
	public Usuario buscarPorEmail(String email) {
		return usuarioDao.buscarPorEmail(email);
	}

	@Override
	@Transactional
	public void atualizaOuInsereUsuarioPorEmail(Usuario usuario) {
		Usuario usuarioFromBD = usuarioDao.buscarPorEmail(usuario.getEmail());
		if (usuarioFromBD == null) {
			usuarioDao.salvar(usuario);
		} else {
			usuario.copyValuesFrom(usuarioFromBD);
		}
	}
}