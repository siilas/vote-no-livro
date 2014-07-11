package br.com.silas.votenolivro.service.test;

import junit.framework.Assert;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.silas.votenolivro.dao.VotoDao;
import br.com.silas.votenolivro.enums.GeneroEnum;
import br.com.silas.votenolivro.model.Livro;
import br.com.silas.votenolivro.model.Voto;
import br.com.silas.votenolivro.service.VotoService;
import br.com.silas.votenolivro.service.impl.VotoServiceImpl;

public class VotoServiceImplTest {

	@InjectMocks
	private VotoService votoService = new VotoServiceImpl();
	
	@Mock
	private VotoDao votoDao;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	public void deveTestarContagemDeVotos() {
		Voto voto = new Voto();
		voto.setLivro(new Livro("Livro Teste", GeneroEnum.AVENTURA));
		voto.setQuantidade(15);
		
		Mockito.when(votoDao.buscarPorId(Mockito.anyInt())).thenReturn(voto);
		
		votoService.contabilizarVoto(1);
		
		boolean result = voto.getQuantidade().equals(16);
		
		Assert.assertEquals(true, result);
	}
}