package br.com.silas.votenolivro.dao;

import br.com.silas.votenolivro.model.Ponto;

public interface PontoDao extends GenericDao<Ponto> {
	
	Ponto buscarPorUsuario(Integer usuario);
}