package br.com.devmedia.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.curso.domain.TipoSexo;
import br.com.devmedia.curso.domain.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {
	
	@PersistenceContext
	EntityManager manager = null;
	
	@Override
    public void salvar(Usuario usuario) {
        manager.persist(usuario); 
    }
 
    @Override
    public void editar(Usuario usuario) {
        manager.merge(usuario);       
    }
 
    @Override
    public void excluir(Long id) {
        manager.remove(manager.getReference(Usuario.class, id));        
    }
 
    @Transactional(readOnly = true)
    @Override
    public Usuario getId(Long id) {
        String jpql = "from Usuario u where u.id = :id";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
 
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getTodos() {
        String jpql = "from Usuario u";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }
 
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getBySexo(TipoSexo sexo) {
        String jpql = "from Usuario u where u.sexo = :sexo";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
        query.setParameter("sexo", sexo);
        return query.getResultList();
    }
 
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getByNome(String nome) {
        String jpql = "from Usuario u where u.nome like :nome or u.sobrenome like :sobrenome";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
        query.setParameter("nome", "%"+nome+"%");
        query.setParameter("sobrenome", "%"+nome+"%");
        return query.getResultList();
    }

	@Override
	@Transactional(readOnly = true)
	public Usuario getByEmailAndSenha(String email, String senha) {
		String jpql = "from Usuario u WHERE u.email = :email and u.senha = :senha";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		return query.getSingleResult();
	}
	
	
}
