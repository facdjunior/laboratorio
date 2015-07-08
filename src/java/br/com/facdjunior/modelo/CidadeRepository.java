package br.com.facdjunior.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;



/**
 *
 * @author Francisco Junior 06/07/2015
 */
public class CidadeRepository {
    
    private EntityManager manager;
    private Cidade nome;
    private Cidade uf_codigo;
    private Cidade codIBGE;
    

    
    
    public Cidade getNome() {
        return nome;
    }

    public void setNome(Cidade nome) {
        this.nome = nome;
    }

    public Cidade getUF() {
        return uf_codigo;
    }

    public void setUF(Cidade UF) {
        this.uf_codigo = UF;
    }

    public Cidade getCodIBGE() {
        return codIBGE;
    }

    public void setCodIBGE(Cidade codIBGE) {
        this.codIBGE = codIBGE;
    }
    
    
    
     public CidadeRepository(EntityManager manager){
        this.manager = manager;
    }

        public void adicionaCidade(Cidade cidade){
        this.manager.persist(cidade);
    }
    public List<Cidade> buscaTodos(){
        Query query = this.manager.createQuery("select x from Cidade x ORDER BY X.nome");
        return query.getResultList();
    }
    public List<UF>buscaUF(){
        Query query = this.manager.createQuery("select uf from UF uf ORDER BY uf.sigla");
        return query.getResultList();
    }
}