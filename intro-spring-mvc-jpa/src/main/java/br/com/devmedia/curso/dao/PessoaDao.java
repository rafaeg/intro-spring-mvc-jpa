package br.com.devmedia.curso.dao;

import java.util.List;

import br.com.devmedia.curso.domain.Pessoa;

public interface PessoaDao {
	
	void salvar(Pessoa umaPessoa);
	
	void editar(Pessoa UmaPessoa);
	
	void excluir(Long id);
	
	Pessoa getId(Long id);
	
	List<Pessoa> getTodosPessoa(); 
	
	List<Pessoa> getByNomePessoa(String nome);
	
}
