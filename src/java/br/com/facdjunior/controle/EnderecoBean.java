package br.com.facdjunior.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UISelectOne;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.facdjunior.modelo.Bairro;
import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.UF;
import br.com.facdjunior.modelo.UFRepository;
import br.com.facdjunior.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@Named
@ViewScoped
public class EnderecoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private EntityManager manager;
    
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("SysLab_PU");
    private EntityManager em = factory.createEntityManager();

    private List<UF> ufs;
    private List<Cidade> cidades;
    private List<Bairro> bairros;

    private UF uf;
    private Cidade cidade;
 
    
    public List<UF> getUffs() {
        
                
		if (ufs == null) {
			this.ufs = em.createQuery("select uf from UF uf order by uf.sigla", UF.class).getResultList();
		}
		return this.ufs;
	}
    
    
    public void atualizaCidades(AjaxBehaviorEvent event) {
        this.cidade = null;
        this.cidades = null;
        this.bairros = null;

        UF uf = (UF) ((UISelectOne) event.getSource()).getValue();
        if (uf != null) {
            this.cidades = manager
                    .createQuery("select c from Cidade c where c.uf = :uf order by c.nome", Cidade.class)
                    .setParameter("uf", uf)
                    .getResultList();
        }
    }

    public void atualizaBairros(AjaxBehaviorEvent event) {
        this.bairros = null;

        Cidade cidade = (Cidade) ((UISelectOne) event.getSource()).getValue();
        if (cidade != null) {
            this.bairros = manager
                    .createQuery("select b from Bairro b where b.cidade = :cidade order by b.nome", Bairro.class)
                    .setParameter("cidade", cidade)
                    .getResultList();
        }
    }

    public List<Cidade> getCidades() {
        return this.cidades;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public UF getUf() {
        return this.uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        EntityManager manager = (EntityManager)request.getAttribute("EntityManager");
        
        return manager;
    }
}

