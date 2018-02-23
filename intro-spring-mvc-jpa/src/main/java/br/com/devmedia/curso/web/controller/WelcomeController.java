package br.com.devmedia.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.devmedia.curso.domain.Usuario;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("usuario") Usuario user, Model model) {
		return "/login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		//return "welcome";
		return "redirect:/usuario/todos";
	}

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ModelAndView teste() {
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("teste", "Olá, eu sou o spring MVC.");
		return view;
	}
}
