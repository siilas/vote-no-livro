package br.com.silas.votenolivro.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.silas.votenolivro.dto.VotacaoDto;
import br.com.silas.votenolivro.exception.ServiceException;
import br.com.silas.votenolivro.model.Livro;
import br.com.silas.votenolivro.service.LivrosService;
import br.com.silas.votenolivro.service.VotacaoLivroService;

@Controller
@RequestMapping("/votacao")
public class EscolheLivroController {

	@Autowired
	private LivrosService livroService;
	
	@Autowired
	private VotacaoLivroService votacaoLivroService;
	
	@RequestMapping("/exibe.do")
	public ModelAndView exibeLivros(@RequestParam("usuario") Integer usuario) {
		ModelAndView modelAndView = new ModelAndView("index");
		try {	
			List<Livro> livros = livroService.buscarLivrosInicias();
			modelAndView = new ModelAndView("escolheLivro");
			modelAndView.addObject("votacao", new VotacaoDto(usuario));
			modelAndView.addObject("livros", livros);
		} catch (ServiceException e) {
			modelAndView.addObject("msgError", e.getMensagem());
			modelAndView.addObject("msgErrorArgs", e.getArgumentos());
		}
		return modelAndView;
	}
	
	@RequestMapping("/votar.do")
	public ModelAndView votaLivro(@ModelAttribute("votacao") VotacaoDto votacao) {
		ModelAndView modelAndView = new ModelAndView("index");
		try {	
			List<Livro> livros = votacaoLivroService.contabilizaVotoEBuscaLivros(votacao);
			if (CollectionUtils.isEmpty(livros) || livros.size() == 1) {
				return new ModelAndView("redirect:/votos.do");
			}
			modelAndView = new ModelAndView("escolheLivro");
			modelAndView.addObject("votacao", votacao);
			modelAndView.addObject("livros", livros);
		} catch (ServiceException e) {
			modelAndView.addObject("msgError", e.getMensagem());
			modelAndView.addObject("msgErrorArgs", e.getArgumentos());
		}
		return modelAndView;
	}
}