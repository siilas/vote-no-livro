package br.com.silas.votenolivro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dao.GenericDao;
import br.com.silas.votenolivro.dao.LivroDao;
import br.com.silas.votenolivro.model.Livro;
import br.com.silas.votenolivro.service.LivrosService;

@Service
public class LivroServiceImpl extends GenericServiceImpl<Livro> implements LivrosService {

	private static final Integer LIMITE_LIVROS = 2;
	
	@Autowired
	private LivroDao livroDao;
	
	@Override
	public GenericDao<Livro> getDao() {
		return livroDao;
	}

	@Override
	@Transactional
	public List<Livro> buscarLivrosDiferentesDe(List<Integer> ids) {
		return livroDao.buscarLivrosDiferentesDe(ids, LIMITE_LIVROS);
	}
	
	@Override
	@Transactional
	public List<Livro> buscarLivrosInicias() {
		return livroDao.buscarLivros(LIMITE_LIVROS);
	}
}