package br.com.silas.votenolivro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dao.GenericDao;
import br.com.silas.votenolivro.dao.VotoDao;
import br.com.silas.votenolivro.model.Voto;
import br.com.silas.votenolivro.service.VotoService;

@Service
public class VotoServiceImpl extends GenericServiceImpl<Voto> implements VotoService {

	@Autowired
	private VotoDao votoDao;
	
	@Override
	public GenericDao<Voto> getDao() {
		return votoDao;
	}

	@Override
	@Transactional
	public void contabilizarVoto(Integer livro) {
		Voto voto = votoDao.buscarPorLivro(livro);
		if (voto != null) {
			voto.aumentaUmVoto();
			votoDao.salvar(voto);
		} else {
			votoDao.salvar(new Voto(livro, 1));
		}
	}
}