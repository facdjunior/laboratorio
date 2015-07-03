/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.bean.converter;

import br.com.facdjunior.modelo.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Francisco Junior 03/07/2015
 */
@FacesConverter("cidadeConverter")
public class CidadeConverter implements Converter {

	@Inject
	private EntityManager entityManager;
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		return entityManager.find(Cidade.class, Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		return String.valueOf(((Cidade) value).getCodigo());
	}

}

