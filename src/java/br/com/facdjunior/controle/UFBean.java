package br.com.facdjunior.controle;

/**
 *
 * @author Francisco Junior 08/07/2015
 */


import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import br.com.facdjunior.modelo.UF;
import br.com.facdjunior.modelo.UFRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ViewScoped
public class UFBean implements Serializable{


	private UF uf = new UF();
        private UFRepository rep = new UFRepository(null);
        
        //ADICIONA NOVO REGISTRO
    public void adicionaUF(){
        EntityManager manager = this.getEntityManager();
        UFRepository repository = new UFRepository(manager);
        
        repository.adiciona(this.uf);
        this.uf = new UF();
    }
    
    //MOSTRA REGISTROS CADASTRADOS
    public List<UF> getUfss(){
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

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public UFRepository getRep() {
        return rep;
    }

    public void setRep(UFRepository rep) {
        this.rep = rep;
    }
    
}

