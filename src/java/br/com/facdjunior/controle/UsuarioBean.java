package br.com.facdjunior.controle;

import br.com.facdjunior.modelo.Usuario;
import br.com.facdjunior.modelo.UsuarioRepository;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Francisco Junior 01/07/2015
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {
    
  

    private Usuario usuario = new Usuario();
    private UsuarioRepository repo = new UsuarioRepository(null);
  
    
    //AUTENTICA LOGIN
    public String envia() {
        usuario = repo.getUsuario(usuario.getNome(), usuario.getSenha());
        if (usuario == null) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
            return null;
        } else {
            return "/Usuario";
            
        }
    }
    
    
    //ADICIONA NOVO REGISTRO
    public void adicionaUsuario(){
        EntityManager manager = this.getEntityManager();
        UsuarioRepository repository = new UsuarioRepository(manager);
        
        repository.adiciona(this.usuario);
        this.usuario = new Usuario();
    }
    //MOSTRA REGISTROS CADASTRADOS
    public List<Usuario> getUsuarios(){
        EntityManager manager = this.getEntityManager();
        UsuarioRepository repository = new UsuarioRepository(manager);
        return repository.buscaTodos();
    }
  
   
    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        EntityManager manager = (EntityManager)request.getAttribute("EntityManager");
        
        return manager;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
