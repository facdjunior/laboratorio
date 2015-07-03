/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.bean.converter;

import br.com.facdjunior.modelo.UF;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Francisco Junior
 */
@FacesConverter("ufConverter")
public class UFConverter implements Converter {

	@Inject
	private EntityManager entityManager;
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		return entityManager.find(UF.class, Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		return String.valueOf(((UF) value).getCodigo());
	}

}

