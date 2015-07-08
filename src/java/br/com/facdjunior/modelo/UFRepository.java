package br.com.facdjunior.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Francisco Junior 06/07/2015
 */
public class UFRepository {
    
    private EntityManager manager;
    private UF nome;
    private UF silga;
    private UF codIBGE;

    
    public UF getNome() {
        return nome;
    }

    public void setNome(UF nome) {
        this.nome = nome;
    }

    public UF getSilga() {
        return silga;
    }

    public void setSilga(UF silga) {
        this.silga = silga;
    }

    public UF getCodIBGE() {
        return codIBGE;
    }

    public void setCodIBGE(UF codIBGE) {
        this.codIBGE = codIBGE;
    }
    
    
     public UFRepository(EntityManager manager){
        this.manager = manager;
    }

        public void adiciona(UF uf){
        this.manager.persist(uf);
    }
    public List<UF> buscaTodos(){
        Query query = this.manager.createQuery("select x from UF x ORDER BY X.nome");
        return query.getResultList();
    }
    
}
