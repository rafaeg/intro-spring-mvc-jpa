package br.com.devmedia.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( value = "contatos")
public class ContatosController {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listContatos () {
		return "/contatos/list";
	}
	
	
}
