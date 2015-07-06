/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.controle;

import br.com.facdjunior.modelo.Bairro;
import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.UF;
import java.io.Serializable;
import java.util.List;
import javax.faces.component.UISelectOne;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.inject.Named;


/**
 *
 * @author Francisco Junior 03/07/2015
 */
@Named
@ViewScoped
public class EnderecoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private EntityManager entityManager;
	
	private List<UF>ufs;
	private List<Cidade> cidades;
	/*private List<Bairro> bairros;*/

	private UF uf = new UF();
	private Cidade cidade;
	
	public List<UF> getUfs() {
		if (uf == null) {
			this.ufs = entityManager.createQuery("select uf from UF uf order by uf.sigla", UF.class).getResultList();
		}
		return this.ufs;
	}

	public void atualizaCidades(AjaxBehaviorEvent event) {
		this.cidade = null;
		this.cidades = null;
		//this.bairros = null;

		UF uf = (UF) ((UISelectOne) event.getSource()).getValue();
		if (uf != null) {
			this.cidades = entityManager
					.createQuery("select c from Cidade c where c.uf = :uf order by c.nome", Cidade.class)
					.setParameter("uf", uf)
					.getResultList();
		}
	}
/*
	public void atualizaBairros(AjaxBehaviorEvent event) {
		this.bairros = null;

		Cidade cidade = (Cidade) ((UISelectOne) event.getSource()).getValue();
		if (cidade != null) {
			this.bairros = entityManager
					.createQuery("select b from Bairro b where b.cidade = :cidade order by b.nome", Bairro.class)
					.setParameter("cidade", cidade)
					.getResultList();
		} 
	}
*/
	public List<Cidade> getCidades() {
		return this.cidades;
	}
/*
	public List<Bairro> getBairros() {
		return bairros;
	}
	*/
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
	
}
