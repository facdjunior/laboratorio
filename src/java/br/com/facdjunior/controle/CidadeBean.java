/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.controle;

import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.CidadeRepository;
import br.com.facdjunior.modelo.UF;
import br.com.facdjunior.modelo.UFRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Francisco Junior 08/07/2015
 */
@ManagedBean
@Named
@ViewScoped
public class CidadeBean {
    
    private Cidade cidade = new Cidade();
    private CidadeRepository repCidade = new CidadeRepository(null);

    
     public void adicionaCidades(){
        EntityManager manager = this.getEntityManager();
         CidadeRepository repository = new CidadeRepository(manager);
        
        repository.adicionaCidade(this.cidade);
        this.cidade = new Cidade();
    }
    
    //MOSTRA REGISTROS CADASTRADOS
    public List<Cidade> getCidades(){
        EntityManager manager = this.getEntityManager();
        CidadeRepository repository = new CidadeRepository(manager);
        return repository.buscaTodos();
    }
	
    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        EntityManager manager = (EntityManager)request.getAttribute("EntityManager");
        
        return manager;
    }
    
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public CidadeRepository getRepCidade() {
        return repCidade;
    }

    public void setRepCidade(CidadeRepository repCidade) {
        this.repCidade = repCidade;
    }
    
    
    
}
