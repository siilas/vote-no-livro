package br.com.silas.votenolivro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.silas.votenolivro.exception.ServiceException;
import br.com.silas.votenolivro.model.Usuario;
import br.com.silas.votenolivro.service.UsuarioService;
import br.com.silas.votenolivro.validator.UsuarioValidator;

@Controller
public class HomeController {

	@Autowired
	private UsuarioService usuarioService;
			
	@RequestMapping("/index.do")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	@RequestMapping("/iniciar.do")
	public ModelAndView iniciaVotacao(@ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			if (!result.hasErrors()) {
				usuarioService.atualizaOuInsereUsuarioPorEmail(usuario);
				modelAndView = new ModelAndView("redirect:/votacao/exibe.do");
				modelAndView.addObject("usuario", usuario.getId());
			}
		} catch (ServiceException e) {
			modelAndView.addObject("msgError", e.getMensagem());
			modelAndView.addObject("msgErrorArgs", e.getArgumentos());
		}
		return modelAndView;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(new UsuarioValidator());
	}
}