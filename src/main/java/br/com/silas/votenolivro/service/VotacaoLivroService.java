package br.com.silas.votenolivro.service;

import java.util.List;

import br.com.silas.votenolivro.dto.VotacaoDto;
import br.com.silas.votenolivro.model.Livro;

public interface VotacaoLivroService {

	List<Livro> contabilizaVotoEBuscaLivros(VotacaoDto votacao);
}