/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.filters;

import br.com.facdjunior.modelo.Bairro;
import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.UF;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Francisco Junior 03/07/2015
 */
@Startup
@Singleton
public class Setup {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void init() {
		UF rj = new UF(1, "RJ", "Rio de Janeiro");
		
		entityManager.persist(rj);
		
		Cidade rio = new Cidade(1, "Rio de Janeiro", rj);
		Cidade niteroi = new Cidade(2, "Niterói", rj);
		
		entityManager.persist(rio);
		entityManager.persist(niteroi);
		
		entityManager.persist(new Bairro(1, "Catete", rio));
		entityManager.persist(new Bairro(2, "Méier", rio));
		entityManager.persist(new Bairro(3, "Penha", rio));
		entityManager.persist(new Bairro(4, "Botafogo", rio));
		entityManager.persist(new Bairro(5, "Glória", rio));

		entityManager.persist(new Bairro(6, "Icaraí", niteroi));
		entityManager.persist(new Bairro(7, "Centro", niteroi));
		entityManager.persist(new Bairro(8, "Santa Rosa", niteroi));
		entityManager.persist(new Bairro(9, "Barreto", niteroi));
		entityManager.persist(new Bairro(10, "Engenhoca", niteroi));
		
		
		UF sp = new UF(2, "SP", "São Paulo");
		
		entityManager.persist(sp);
		
		Cidade saoPaulo = new Cidade(3, "São Paulo", sp);
		Cidade campinas = new Cidade(4, "Campinas", sp);
		
		entityManager.persist(saoPaulo);
		entityManager.persist(campinas);
		
		entityManager.persist(new Bairro(11, "Aclimação", saoPaulo));
		entityManager.persist(new Bairro(12, "Brás", saoPaulo));
		entityManager.persist(new Bairro(13, "Ibirapuera", saoPaulo));
		entityManager.persist(new Bairro(14, "Campos Elíseos", saoPaulo));
		entityManager.persist(new Bairro(15, "Vila Mariana", saoPaulo));

		entityManager.persist(new Bairro(16, "Guanabara", campinas));
		entityManager.persist(new Bairro(17, "Vila Industrial", campinas));
		entityManager.persist(new Bairro(18, "Vila Olímpia", campinas));
		entityManager.persist(new Bairro(19, "Gramado", campinas));
		entityManager.persist(new Bairro(20, "Jardim Campinas", campinas));
		
		
	}
	
	
}
