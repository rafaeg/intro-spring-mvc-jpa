package br.com.devmedia.curso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.devmedia.curso.dao.UsuarioDao;
import br.com.devmedia.curso.domain.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@RequestMapping( value = "/loginForm", method = RequestMethod.POST)
	public String loginForm(@ModelAttribute("usuario") Usuario user, Model model) {
		String caminho = null;
		
		System.out.println("Model " + model);
		System.out.println("Usuario" + user);
		try {
			Usuario usuario = usuarioDao.getByEmailAndSenha(user.getEmail(), user.getSenha());
			caminho = "redirect:/usuario/todos";
		}catch(Exception ex) {
			model.addAttribute("message", "Usuário inválido");
			caminho = "/login";
		}		
		return caminho;
	}
	
}
