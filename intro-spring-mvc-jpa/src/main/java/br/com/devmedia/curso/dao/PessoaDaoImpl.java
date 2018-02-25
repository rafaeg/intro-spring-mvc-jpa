package br.com.devmedia.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.curso.domain.Pessoa;

@Repository
@Transactional
public class PessoaDaoImpl implements PessoaDao{

	@PersistenceContext
	EntityManager manager = null;
	
	@Override
	public void salvar(Pessoa umaPessoa) {
		manager.persist(umaPessoa);
	}

	@Override
	public void editar(Pessoa umaPessoa) {
		manager.merge(umaPessoa);
		
	}

	@Override
	public void excluir(Long id) {
		manager.remove(manager.getReference(Pessoa.class, id));		
	}

	@Override
	public Pessoa getId(Long id) {
		String jpql = "from Pessoa p WHERE p.id = :id";
		TypedQuery<Pessoa> query = manager.createQuery(jpql, Pessoa.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pessoa> getTodosPessoa() {
		String jpql = "from Pessoa p";
		TypedQuery<Pessoa> query = manager.createQuery(jpql, Pessoa.class);
		return query.getResultList();
	}

	@Override
	public List<Pessoa> getByNomePessoa(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
