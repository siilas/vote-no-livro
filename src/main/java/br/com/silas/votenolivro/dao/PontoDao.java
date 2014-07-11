package br.com.silas.votenolivro.dao;

import java.util.List;

import br.com.silas.votenolivro.model.Ponto;

public interface PontoDao extends GenericDao<Ponto> {
	
	Ponto buscarPorUsuario(Integer usuario);
	
	List<Ponto> buscarPontuacao();
}