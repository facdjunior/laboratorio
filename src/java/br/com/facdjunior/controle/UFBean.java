/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.controle;
import br.com.facdjunior.modelo.UF;
import br.com.facdjunior.modelo.UFRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Francisco Junior 06/07/2015  
 */
@ManagedBean
@ViewScoped
public class UFBean {
      
    private UF uf = new UF(); 

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
    
    
//ADICIONA NOVO REGISTRO
    public void adicionar(){
        EntityManager manager = this.getEntityManager();
        UFRepository repository = new UFRepository(manager);
        
        repository.adiciona(this.uf);
        this.uf = new UF();
    }
    //MOSTRA REGISTROS CADASTRADOS
    public List<UF> getUfs(){
        EntityManager manager = this.getEntityManager();
        UFRepository repository = new UFRepository(manager);
        return repository.buscaTodos();
    }
  
    
    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        EntityManager manager = (EntityManager)request.getAttribute("EntityManager");
        
        return manager;
    }
    
}
