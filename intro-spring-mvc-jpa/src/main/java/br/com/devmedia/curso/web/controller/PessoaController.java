package br.com.devmedia.curso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devmedia.curso.dao.PessoaDao;
import br.com.devmedia.curso.domain.Pessoa;

@Controller
@RequestMapping(value = "pessoa")
public class PessoaController {
		
	    @Autowired
		private PessoaDao pessoaDao;
	
	
		@RequestMapping(value = "/listarPessoa", method = RequestMethod.GET)
		public String listPessoa(Model model) {
			String caminho = "/pessoas/list";
			model.addAttribute("pessoas", pessoaDao.getTodosPessoa());
			return caminho;
		}
		
		@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
		public String cadastro(@ModelAttribute("pessoa") Pessoa pessoa, 
							   Model model) {
			String caminho = "/pessoas/add";
			return caminho;
		}
		
		@PostMapping(value = "/save")
		public String save(@ModelAttribute("pessoa") Pessoa pessoa, 
								 BindingResult result,
								 RedirectAttributes attr, 
								 Model model) {
			pessoaDao.salvar(pessoa);
			attr.addFlashAttribute("message", "Pessoa inserida com sucesso");		
			return "redirect:/pessoa/listarPessoa";
		}
		
		@GetMapping(value="/preUpdate/{id}")
		public ModelAndView preUpdate(@PathVariable("id") Long id, 
								ModelMap model) {
			Pessoa umaPessoa = pessoaDao.getId(id);
			model.addAttribute("pessoa", umaPessoa);
			return new ModelAndView("/pessoas/add", model);
		}
		
		@PostMapping(value = "/update")
		public ModelAndView update(@ModelAttribute("pessoa") Pessoa pessoa, 
								   BindingResult result,
								   RedirectAttributes attr) {
			ModelAndView model;
			if(result.hasErrors()) {
				 model = new ModelAndView("/pessoas/add");
			}
			pessoaDao.editar(pessoa);
			attr.addFlashAttribute("message", "Pessoa atualizada com sucesso");
			model = new ModelAndView("redirect:/pessoa/listarPessoa");
			return model;
		}
		
		@GetMapping(value="/delete/{id}")
		public ModelAndView delete(@PathVariable("id") Long id,
								   RedirectAttributes attr) {
			pessoaDao.excluir(id);
			attr.addFlashAttribute("message", "Pessoa excluída com sucesso");
			ModelAndView model = new ModelAndView("redirect:/pessoa/listarPessoa");
			return model;
		}
		
}
