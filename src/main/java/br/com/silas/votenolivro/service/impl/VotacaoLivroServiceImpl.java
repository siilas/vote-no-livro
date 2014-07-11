package br.com.silas.votenolivro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.silas.votenolivro.dto.VotacaoDto;
import br.com.silas.votenolivro.model.Livro;
import br.com.silas.votenolivro.service.LivrosService;
import br.com.silas.votenolivro.service.PontoService;
import br.com.silas.votenolivro.service.VotacaoLivroService;
import br.com.silas.votenolivro.service.VotoService;

@Service
public class VotacaoLivroServiceImpl implements VotacaoLivroService {
	
	@Autowired
	private PontoService pontoService;
	
	@Autowired
	private VotoService votoService;
	
	@Autowired
	private LivrosService livroService;
	
	@Override
	@Transactional
	public List<Livro> contabilizaVotoEBuscaLivros(VotacaoDto votacao) {
		pontoService.contabilizarPonto(votacao.getUsuario());
		votoService.contabilizarVoto(votacao.getVotoAtual());
		votacao.getIds().add(votacao.getVotoAtual());
		votacao.setVotoAtual(null);
		return livroService.buscarLivrosDiferentesDe(votacao.getIds());
	}
}