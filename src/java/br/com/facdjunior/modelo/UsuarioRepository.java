package br.com.facdjunior.modelo;

import br.com.facdjunior.controle.UsuarioBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Francisco Junior 01/07/2015
 */
public class UsuarioRepository {
    
    private EntityManager manager;
  
    private Usuario usuario;
    private Usuario senha;
    
   private EntityManagerFactory factory = Persistence.createEntityManagerFactory("SysLab_PU");
    private EntityManager em = factory.createEntityManager();
    
    public Usuario getUsuario(String nome, String senha) {
        try {
            Usuario usuario = (Usuario) em.createQuery("SELECT u from Usuario u where u.nome = :nome and u.senha = :senha").setParameter("nome", nome).setParameter("senha", senha).getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getSenha() {
        return senha;
    }
    
    public void setSenha(Usuario senha) {
        this.senha = senha;
    }
  
      public UsuarioRepository(EntityManager manager){
        this.manager = manager;
    }
    public void adiciona(Usuario usuario){
        this.manager.persist(usuario);
    }
    public List<Usuario> buscaTodos(){
        Query query = this.manager.createQuery("select x from Usuario x");
        return query.getResultList();
    }
    
}

