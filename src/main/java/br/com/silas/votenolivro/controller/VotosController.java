package br.com.silas.votenolivro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.silas.votenolivro.exception.ServiceException;
import br.com.silas.votenolivro.model.Voto;
import br.com.silas.votenolivro.service.VotoService;

@Controller
public class VotosController {

	@Autowired
	private VotoService votoService;
	
	@RequestMapping("/votos.do")
	public ModelAndView exibirVotos() {
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			List<Voto> votos = votoService.buscarTodos();
			modelAndView = new ModelAndView("ranking");
			modelAndView.addObject("votos", votos);
		} catch (ServiceException e) {
			modelAndView.addObject("msgError", e.getMensagem());
			modelAndView.addObject("msgErrorArgs", e.getArgumentos());
		}
		return modelAndView;
	}
}