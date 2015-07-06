/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Cidade UF;
    private Cidade codIBGE;

    public Cidade getNome() {
        return nome;
    }

    public void setNome(Cidade nome) {
        this.nome = nome;
    }

    public Cidade getUF() {
        return UF;
    }

    public void setUF(Cidade UF) {
        this.UF = UF;
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
}