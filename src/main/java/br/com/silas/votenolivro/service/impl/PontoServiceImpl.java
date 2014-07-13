package br.com.silas.votenolivro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dao.GenericDao;
import br.com.silas.votenolivro.dao.PontoDao;
import br.com.silas.votenolivro.model.Ponto;
import br.com.silas.votenolivro.service.PontoService;

@Service
public class PontoServiceImpl extends GenericServiceImpl<Ponto> implements PontoService {

	@Autowired
	private PontoDao pontoDao;
	
	@Override
	public GenericDao<Ponto> getDao() {
		return pontoDao;
	}

	@Override
	@Transactional
	public void contabilizarPonto(Integer usuario) {
		Ponto ponto = pontoDao.buscarPorUsuario(usuario);
		if (ponto != null) {
			ponto.aumentaUmPonto();
			pontoDao.salvar(ponto);
		} else {
			pontoDao.salvar(new Ponto(usuario, 1));
		}		
	}

	@Override
	@Transactional
	public List<Ponto> buscarPontuacao() {
		return pontoDao.buscarPontuacao();
	}
}