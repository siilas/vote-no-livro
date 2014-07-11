package br.com.silas.votenolivro.service;

import br.com.silas.votenolivro.model.Voto;

public interface VotoService extends GenericService<Voto> {

	void contabilizarVoto(Integer livro);
}