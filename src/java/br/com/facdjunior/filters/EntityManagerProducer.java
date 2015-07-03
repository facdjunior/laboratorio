/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.filters;

/**
 *
 * @author Francisco Junior 03/07/2015
 */
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EntityManagerProducer {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
