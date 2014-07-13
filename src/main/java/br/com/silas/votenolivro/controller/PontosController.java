package br.com.silas.votenolivro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.silas.votenolivro.exception.ServiceException;
import br.com.silas.votenolivro.model.Ponto;
import br.com.silas.votenolivro.service.PontoService;

@Controller
public class PontosController {

	@Autowired
	private PontoService pontoService;
	
	@RequestMapping("/pontos.do")
	public ModelAndView buscarVotos() {
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			List<Ponto> pontos = pontoService.buscarPontuacao();
			modelAndView = new ModelAndView("pontos");
			modelAndView.addObject("pontos", pontos);
		} catch (ServiceException e) {
			modelAndView.addObject("msgError", e.getMensagem());
			modelAndView.addObject("msgErrorArgs", e.getArgumentos());
		}
		return modelAndView;
	}
}